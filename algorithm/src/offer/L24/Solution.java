package offer.L24;

import leetcode.common.ListNode;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/13 14:30
 **/
class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
