package leetcode.common;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/15 22:00
 **/
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}