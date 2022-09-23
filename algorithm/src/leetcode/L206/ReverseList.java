package leetcode.L206;

import java.util.LinkedList;

public class ReverseList {
  static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null){
      ListNode nextNode = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextNode;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(10);

    ListNode node1 = node;

    System.out.println(node.equals(node1));
    node.val = 20;

    node = null;

    System.out.println(node1.val);
  }
}
