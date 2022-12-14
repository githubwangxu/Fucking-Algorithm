package leetcode.L98;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class TreeNode {
  public int val;

  TreeNode left;
  TreeNode right;
}

public class ValidBST {
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isInRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean isInRange(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }
    if (node.val < min || node.val > max) {
      return false;
    }
    return isInRange(node.left, min, node.val) && isInRange(node.right, node.val, max);
  }
}

