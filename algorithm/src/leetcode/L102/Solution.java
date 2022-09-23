package leetcode.L102;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/20 23:19
 **/
public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levelList = new ArrayList<>();
    if (root == null) {
      return levelList;
    }
    Deque<TreeNode> nodeDeque = new ArrayDeque<>();
    nodeDeque.offer(root);
    while (nodeDeque.size() > 0) {
      int size = nodeDeque.size();
      List<Integer> subLevelList = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = nodeDeque.remove();
        if (treeNode.left != null) {
          nodeDeque.add(treeNode.left);
        }
        if (treeNode.right != null) {
          nodeDeque.add(treeNode.right);
        }
        subLevelList.add(treeNode.val);
      }
      levelList.add(subLevelList);
    }
    return levelList;
  }
}
