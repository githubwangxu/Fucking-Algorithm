package leetcode.L895hard;

import java.util.*;

/**
 * @description: 这个算方法一，思路是没有问题的，就是太慢了，每次pop操作都需要循环一下
 * @author: Jack
 * @date: 2022/9/7 13:32
 * <p>
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
public class FreqStackLow {
  private LinkedList<Integer> dataList;
  private HashMap<Integer, Integer> freqMap;

  public FreqStackLow() {
    dataList = new LinkedList<>();
    freqMap = new HashMap<>();

  }

  public void push(int val) {
    dataList.addFirst(val);
    int freq = freqMap.getOrDefault(val, 0) + 1;
    freqMap.put(val, freq);
  }

  //弹出出现频率最高的第一个元素
  public int pop() {
    int maxFreq = Collections.max(freqMap.values());

    //找到出现频率最高的元素
    for (int i = 0; i < dataList.size(); i++) {
      int val = dataList.get(i);
      int valFreq = freqMap.get(val);
      if (Objects.equals(valFreq, maxFreq)) {
        dataList.remove(i);
        if (valFreq == 1) {
          freqMap.remove(val);
        } else {
          freqMap.put(val, valFreq - 1);
        }
        return val;
      }
    }
    //不会走到这里
    return Integer.MAX_VALUE;
  }

  public static void main(String[] args) {
    FreqStackLow freqStackLow = new FreqStackLow();
    freqStackLow.push(5);//堆栈为 [5]
    freqStackLow.push(7);//堆栈是 [5,7]
    freqStackLow.push(5);//堆栈是 [5,7,5]
    freqStackLow.push(7);//堆栈是 [5,7,5,7]
    freqStackLow.push(4);//堆栈是 [5,7,5,7,4]
    freqStackLow.push(5);//堆栈是 [5,7,5,7,4,5]
    System.out.println(freqStackLow.pop());//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
    System.out.println(freqStackLow.pop());//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
    System.out.println(freqStackLow.pop());//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
    System.out.println(freqStackLow.pop());//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
  }
}
