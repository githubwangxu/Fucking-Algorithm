package leetcode.L895hard;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/7 15:56
 **/
class Node implements Comparable<Node> {
  public int val;
  public int freq;
  public int index;

  public Node(int val, int freq, int index) {
    this.val = val;
    this.freq = freq;
    this.index = index;
  }

  @Override
  public int compareTo(Node o) {
    if (o.freq > this.freq) {
      return 1;
    }
    if (o.freq < this.freq) {
      return -1;
    }
    //出现频率相等，按照出现顺序排序
    if (o.index > this.index) {
      return 1;
    }
    if (o.index < this.index) {
      return -1;
    }
    //一般情况下不会返回0，只有两个一摸一样的节点比较。但是满足自反性，需要返回0的情况
    return 0;
  }

  @Override
  public String toString() {
    return "val=" + this.val + ", index = " + this.index + ", freq=" + this.freq;
  }
}
public class FreqStack {
  public int size = 0;
  public HashMap<Integer, Integer> freqMap;
  public PriorityQueue<Node> queue;


  public FreqStack() {
    freqMap = new HashMap<>();
    queue = new PriorityQueue<>();
  }

  public void push(int val) {
    int currentFreq = freqMap.getOrDefault(val, 0) + 1;
    Node currentNode = new Node(val, currentFreq, size++);
    freqMap.put(val, currentFreq);
    queue.add(currentNode);
  }

  public int pop() {
    Node node = queue.poll();
    freqMap.put(node.val, node.freq -1);
    System.out.println(node.toString());
    return node.val;
  }

  public static void main(String[] args) {
    FreqStack freqStack = new FreqStack();
//    freqStack.push(5);//堆栈为 [5]
//    freqStack.push(7);//堆栈是 [5,7]
//    freqStack.push(5);//堆栈是 [5,7,5]
//    freqStack.push(7);//堆栈是 [5,7,5,7]
//    freqStack.push(4);//堆栈是 [5,7,5,7,4]
//    freqStack.push(5);//堆栈是 [5,7,5,7,4,5]
//    freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
//    freqStack.pop();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
//    freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
//    freqStack.pop();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。

    freqStack.push(1);
    freqStack.push(1);
    freqStack.push(1);
    freqStack.push(2);

    freqStack.pop();
    freqStack.pop();

    freqStack.push(2);
    freqStack.push(2);
    freqStack.push(1);
    freqStack.pop();
    freqStack.pop();
    freqStack.pop();

  }
}


