package leetcode.L543;

import leetcode.common.TreeNode;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/18 21:39
 **/
public class Solution {
  public int ans;

  public int diameterOfBinaryTree(TreeNode root) {
    ans = 0;
    calcDepth(root);
    return ans;
  }

  public int calcDepth(TreeNode node) {
    if (node == null) {
      return 1;
    }
    int leftDepth = calcDepth(node.left);
    int rightDepth = calcDepth(node.right);
    ans = Math.max(ans, leftDepth + rightDepth - 1);
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
