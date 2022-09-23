package leetcode.L876;

import leetcode.common.ListNode;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/18 16:49
 **/
public class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
