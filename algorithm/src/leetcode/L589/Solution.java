package leetcode.L589;

import leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/20 23:05
 **/
public class Solution {
  public List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    findChildren(root, result);
    return result;
  }

  public void findChildren(Node node, List<Integer> res) {
    res.add(node.val);
    for (Node children : node.children) {
      findChildren(children, res);
    }
  }
}
