package interview;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/16 14:47
 **/
public class ReverseLinkedList {


  public static Node reverse(Node node) {
    Node prev = null;
    Node head = node;
    while (head != null) {
      Node nextNode = head.next;
      head.next = prev;
      prev = head;
      head = nextNode;
    }
    return prev;
  }

  public static void main(String[] args) {
    Node node3 = new Node(3);
    Node node2 = new Node(2, node3);
    Node node1 = new Node(1, node2);


    Node node = reverse(node1);
    System.out.println(node.val);




  }
}

class Node {
  public int val;
  public Node next;

  public Node(int val){
    this.val = val;
  }

  public Node(int val, Node next){
    this.val = val;
    this.next = next;
  }
}
