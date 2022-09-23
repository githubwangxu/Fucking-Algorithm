package leetcode.L146;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 在LRU的基础上，增加过期淘汰的机制
 */
public class LRUCacheAdvance {

  // 变量1：用于设置清除过期数据的线程池
  private static ScheduledExecutorService swapExpiredPool = new ScheduledThreadPoolExecutor(10);

  // 变量2：用户存储数据,为了保证线程安全，使用了ConcurrentHashMap
  private ConcurrentHashMap<String, Node> cache = new ConcurrentHashMap<>(1024);

  // 变量3：保存最新的过期数据，过期时间最小的数据排在队列前
  private PriorityQueue<Node> expireQueue = new PriorityQueue<>(1024);

  // 构造方法：只要有缓存了，过期清除线程就开始工作
  public LRUCacheAdvance() {
    swapExpiredPool.scheduleWithFixedDelay(new ExpiredNode(), 3, 3, TimeUnit.SECONDS);
  }

  public class ExpiredNode implements Runnable {
    @Override
    public void run() {
      // 第一步：获取当前的时间
      long now = System.currentTimeMillis();
      while (true) {
        // 第二步：从过期队列弹出队首元素，如果不存在，或者不过期就返回
        Node node = expireQueue.peek();
        if (node == null || node.expireTime > now) return;
        // 第三步：过期了那就从缓存中删除，并且还要从队列弹出
        cache.remove(node.key);
        expireQueue.poll();
      }// 此过程为while(true)，一直进行判断和删除操作
    }
  }

  public Object set(String key, Object value, long ttl) {
    // 第一步：获取过期时间点
    long expireTime = System.currentTimeMillis() + ttl;
    // 第二步：新建一个节点
    Node newNode = new Node(key, value, expireTime);
    // 第三步：cache中有的话就覆盖，没有就添加新的，过期时间队列也要添加
    Node old = cache.put(key, newNode);
    expireQueue.add(newNode);
    // 第四步：如果该key存在数据，还要从过期时间队列删除
    if (old != null) {
      expireQueue.remove(old);
      return old.value;
    }
    return null;
  }

  public Object get(String key) {
    //第一步：从cache直接获取，注意这个cache是一个HashMap
    Node n = cache.get(key);
    //第二步：如果n为空那就返回为null,不为空就返回相应的值
    return n == null ? null : n.value;
  }

  //这个Node对用HashMap中每一个节点
  class Node implements Comparable<Node> {
    private String key;
    private Object value;
    private long expireTime;//注意这个过期时间是一个时间点，如11点11分

    public Node(String key, Object value, long expireTime) {
      this.value = value;
      this.key = key;
      this.expireTime = expireTime;
    }

    //按照过期时间进行排序
    @Override
    public int compareTo(Node o) {
      long r = this.expireTime - o.expireTime;
      if (r > 0) return 1;
      if (r < 0) return -1;
      return 0;
    }
  }

  public static void main(String[] args) {
    LRUCacheAdvance cache = new LRUCacheAdvance();
    Long ttl = 1000L;
    cache.set("a",2,ttl);
    cache.set("b",2,ttl);

    System.out.println(cache.get("a"));
  }
}


