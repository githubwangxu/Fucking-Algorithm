package leetcode.L21;

import leetcode.common.ListNode;

public class MergeTwoList {
  class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if (list1 == null && list2 == null) {
        return new ListNode();
      }
      if (list1 == null) {
        return list2;
      }
      if (list2 == null) {
        return list1;
      }
      ListNode head = null, list3 = new ListNode();
      while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
          list3.next = list1;
          list1 = list1.next;
        } else {
          list3.next = list2;
          list2 = list2.next;
        }
        if (head == null) {
          head = list3.next;
        }
        list3 = list3.next;
      }
      if (list1 != null) {
        list3.next = list1;
      }
      if (list2 != null) {
        list3.next = list2;
      }
      return head;
    }
  }

  class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode result = new ListNode();
      ListNode head = null;
      while (list1 != null || list2 != null) {
        int l1 = list1 == null ? Integer.MAX_VALUE : list1.val;
        int l2 = list2 == null ? Integer.MAX_VALUE : list2.val;
        if (head == null) {
          head = l1 < l2 ? list1 : list2;
        }
        if (l1 < l2) {
          result.next = list1;
          list1 = list1.next;
        } else {
          result.next = list2;
          list2 = list2.next;
        }
        result = result.next;
      }
      return head;
    }
  }
}
