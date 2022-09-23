package temp;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class HashMapMock {

  ThreadLocal threadLocal = new ThreadLocal();
  HashMap hashMap = new HashMap();
  ReentrantLock reentrantLock = new ReentrantLock(true);


  //size 桶容量
  public int size;

  public Node[] data;

  public HashMapMock() {
    size = 16;
    data = new Node[size];
  }

  public HashMapMock(int size) {
    data = new Node[size];
  }


  class Node {
    String key;
    String value;
    Node next;

    public Node(String value) {
      this.value = value;
//      this.next = next;
    }

    public Node(String value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  public void put(String key, String value) {
    int index = hash(key);
    Node curr = data[index];
    if (curr == null) {
      //next ？？
      Node node = new Node(value);
      data[index] = node;
      size++;
      return;
    }
    //追加到链表上
    while (curr != null) {

    }
  }

  private int hash(String key) {
    int hashCode = key.hashCode();
    return hashCode % size;
  }

}
