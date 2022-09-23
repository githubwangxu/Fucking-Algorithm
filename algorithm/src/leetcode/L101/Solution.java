package leetcode.L101;

import leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/20 23:59
 **/
public class Solution {
  public Stack<TreeNode> inorderStack = new Stack<>();

  public boolean isSymmetric(TreeNode root) {
    push(root.left);
    return pop(root.right);
  }

  private void push(TreeNode node) {
    if (node == null) {
      return;
    }
    push(node.left);
    inorderStack.push(node);
    push(node.right);
  }

  private boolean pop(TreeNode node) {
    if (node == null) {
      return true;
    }
    pop(node.left);
    TreeNode existNode  = inorderStack.pop();
    if (existNode == null || existNode.val != node.val){
      return false;
    }
    pop(node.right);
    return true;
  }
}
