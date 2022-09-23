package leetcode.L94;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/20 23:50
 **/
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorder(root, res);
    return res;
  }

  private void inorder(TreeNode node, List<Integer> res) {
    if (node == null) {
      return;
    }
    inorder(node.left, res);
    res.add(node.val);
    inorder(node.right, res);
  }
}
