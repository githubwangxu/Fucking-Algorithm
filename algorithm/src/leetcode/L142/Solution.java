package leetcode.L142;

import leetcode.common.ListNode;

import java.util.HashSet;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/18 17:56
 **/
public class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode node = head;
    HashSet<ListNode> nodeSet = new HashSet<>();
    while (node != null) {
      if (nodeSet.contains(node)) {
        return node;
      }
      nodeSet.add(node);
      node = node.next;
    }
    return null;
  }
}

//快慢指针的算法
class Solution2{
  public ListNode detectCycle(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while (true){
      if (fast == null || fast.next == null){
        return null;
      }
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow)
        break;
    }
    fast = head;
    while (fast != slow){
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

}
