package leetcode.L23;

import leetcode.common.ListNode;

import java.util.PriorityQueue;

public class MergeKLists {
  class PriorityNode implements Comparable<PriorityNode> {
    int val;
    ListNode node;

    PriorityNode(int val, ListNode next) {
      this.val = val;
      this.node = next;
    }

    @Override
    public int compareTo(PriorityNode node) {
      if (this.val > node.val) {
        return 1;
      }
      if (this.val < node.val) {
        return -1;
      }
      return 0;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length < 1) {
      return null;
    }
    PriorityQueue<PriorityNode> priorityNodes = new PriorityQueue<>(lists.length);
    for (int i = 0; i < lists.length; i++) {
      priorityNodes.offer(new PriorityNode(lists[i].val, lists[i]));
    }
    ListNode head = null, tail = null;
    while (!priorityNodes.isEmpty()) {
      ListNode node = priorityNodes.poll().node;
      if (head == null) {
        head = tail = node;
      } else {
        tail.next = node;
      }
      if (node.next != null) {
        priorityNodes.offer(new PriorityNode(node.next.val, node.next));
      }
      tail = tail.next;
    }
    return head;
  }
}

