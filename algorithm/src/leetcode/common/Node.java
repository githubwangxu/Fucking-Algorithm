package leetcode.common;

import java.util.List;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/20 23:05
 **/
public class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}
