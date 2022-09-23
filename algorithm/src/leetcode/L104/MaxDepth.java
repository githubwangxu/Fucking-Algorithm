package leetcode.L104;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * maxDepth = max(leftDepth,rightDepth)
 */


public class MaxDepth {
  /**
   * 方法1
   *
   * @param root
   * @return
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}

class Solution2 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int depth = 0;
    Deque<TreeNode> treeNodeQueue = new ArrayDeque<>();
    treeNodeQueue.add(root);
    while (treeNodeQueue.size() > 0) {
      int size = treeNodeQueue.size();
      while (size > 0) {
        TreeNode node = treeNodeQueue.poll();
        if (node.left != null) {
          treeNodeQueue.add(node.left);
        }
        if (node.right != null) {
          treeNodeQueue.add(node.right);
        }
        size--;
      }
      depth++;
    }
    return depth;
  }
}
