package offer.L09;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * <p>
 * * Your CQueue object will be instantiated and called as such:
 * * CQueue obj = new CQueue();
 * * obj.appendTail(value);
 * * int param_2 = obj.deleteHead();
 */
public class CQueue {
  private Stack<Integer> pushStack = new Stack<>();
  private Stack<Integer> popStack = new Stack<>();

  public CQueue() {
  }

  public void appendTail(int value) {
    pushStack.push(value);
  }

  public int deleteHead() {
    if (popStack.isEmpty()) {
      if (pushStack.isEmpty()) {
        return -1;
      }
      while (pushStack.size() > 0) {
        Integer popNum = pushStack.pop();
        popStack.push(popNum);
      }
    }
    return popStack.pop();
  }
}
