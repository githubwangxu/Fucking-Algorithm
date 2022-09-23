package leetcode.L146;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 实现过期自动删除的一个LRU算法
 * 可以先简单的实现一个自动删除的算法
 */
public class LRUCacheAndExpired {

  private static ScheduledExecutorService clearWorker = new ScheduledThreadPoolExecutor(1);

  private ConcurrentHashMap<Integer, Node> hashTable = new ConcurrentHashMap<>(512);

  private PriorityQueue<Node> expiredQueue = new PriorityQueue<>(512);

  public LRUCacheAndExpired() {
//    clearWorker.scheduleWithFixedDelay(new ClearExpiredKeyTask(), 3L, 1L, TimeUnit.SECONDS);


  }

  public class ClearExpiredKeyTask implements Runnable {
    @Override
    public void run() {
//      while (true) {
        Long now = System.currentTimeMillis();

//        System.out.println(now + "执行过期任务");
        Node node = expiredQueue.peek();
        if (node.expiredTime < now) {
          System.out.println(node);
          hashTable.remove(node.key);
          expiredQueue.poll();
        }
      }
//    }
  }

  public void set(int key, int value, int expiredSeconds) {
    Long expiredTime = System.currentTimeMillis() + expiredSeconds * 1000L;
    Node node = new Node(key, value, expiredTime);
    expiredQueue.add(node);
    hashTable.put(key, node);
  }

  class Node implements Comparable<Node> {
    int key;
    int value;
    Long expiredTime;

    Node prev;
    Node next;

    public Node(int key, int value, Long expiredTime) {
      this.key = key;
      this.value = value;
      this.expiredTime = expiredTime;
    }

    @Override
    public int compareTo(Node o) {
      long result = this.expiredTime - o.expiredTime;
      if (result > 0) return 1;
      if (result < 0) return -1;
      return 0;
    }

    @Override
    public String toString() {
      return "key = " + this.key + ", value = " + this.value + ", 过期时间是 " + this.expiredTime;
    }
  }


  public static void main(String[] args) {
    LRUCacheAndExpired cache = new LRUCacheAndExpired();
    cache.set(1, 1, 10);
    cache.set(2, 1, 5);
    cache.set(3, 1, 1);

  }
}
