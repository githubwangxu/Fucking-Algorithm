package leetcode.L146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 力扣的原题： https://leetcode.cn/problems/lru-cache/
 * <p>
 * * Your LRUCache object will be instantiated and called as such:
 * * LRUCache obj = new LRUCache(capacity);
 * * int param_1 = obj.get(key);
 * * obj.put(key,value);
 * <p>
 * 考察点：双向链表 + 哈希表
 */
public class LRUCache {

  public static void main(String[] args) {
//    LRUCache1 cache1 = new LRUCache1(2);
//    cache1.test();
    /**
     * ["LRUCache","get","get","put","get","put","put","put","put","get","put"]
     * [[1],          [6],[8],[12,1],[2],[15,11],[5,2],[1,15],[4,2],[5],[15,15]]
     */
    LRUCache2 cache2 = new LRUCache2(1);
    cache2.put(12, 1);
    cache2.put(15, 11);
    cache2.put(5, 2);
    cache2.put(1, 15);
    cache2.print();
  }
}

/**
 * 这个是最简单的实现方式,直接继承 LinkHashMap，实现了一些现有的方法
 * <p>
 * 缺陷：获取key之后没有调整缓存的位置
 */
class LRUCache1 extends LinkedHashMap<Integer, Integer> {
  private int capacity;

  public LRUCache1(int capacity) {
    super(capacity);
    this.capacity = capacity;


  }

  public int get(int key) {
    return super.getOrDefault(key, -1);

  }

  public void put(int key, int value) {
    super.put(key, value);

  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
  }

  public void print() {
    System.out.println("<===========");
    this.forEach((key, value) -> System.out.println("key = " + key + "value = " + value));
    System.out.println("===========>");
  }

  public void test() {
    this.put(1, 1);
    this.put(2, 2);
    this.put(3, 3);
    this.print();
    this.get(3);
    this.print();
  }
}

/**
 * 链表 + 散列表的实现
 */
class LRUCache2 {
  private Node head;
  private Node tail;
  private int size;
  private int capacity;

  private HashMap<Integer, Node> hashTable = new HashMap<>();

  public LRUCache2(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    Node node = hashTable.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    add(key, value);
  }

  class Node {
    int key;
    int value;

    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }


  //add new node to head
  public void add(int key, int value) {
    Node existNode = hashTable.get(key);
    if (existNode != null) {
      existNode.value = value;
      moveToHead(existNode);
      return;
    }
    if (size >= capacity) {
      removeLast();
      size--;
    }
    Node node = new Node(key, value);
    if (head == null || tail == null) {
      tail = node;
    } else {
      node.next = head;
      head.prev = node;
    }
    head = node;
    hashTable.put(key, node);
    size++;
  }

  public void moveToHead(Node node) {
    //只有一个元素有不用移动了
    if (node.prev == null) {
      return;
    }
    //如果是尾巴节点，移动一下tail指针
    if (tail == node) {
      tail = node.prev;
    }
    node.prev.next = node.next;
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    node.prev = null;
    node.next = head;
    head.prev = node;
    head = node;
  }

  public void removeLast() {
    Node node = tail;
    hashTable.remove(tail.key);
    tail = node.prev;
  }

  public void print() {
    Node node = head;
    while (node != null) {
      System.out.println("key = " + node.key + ", value = " + node.value);
      node = node.next;
    }
  }
}


