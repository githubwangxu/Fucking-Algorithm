package leetcode.L22M;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/17 16:20
 **/
public class Solution {
  public List<String> generateParenthesis(int n) {
    if (n < 1) {
      return null;
    }
    List<String> res = new ArrayList<>();
    dfs("", n, n, res);
    return res;
  }

  public void dfs(String currStr, int left, int right, List<String> res) {
    if (left == 0 && right == 0) {
      res.add(currStr);
      return;
    }
    if (left > right) {
      return;
    }

    if (left > 0) {
      dfs(currStr + "(", left - 1, right, res);
    }
    if (right > 0) {
      dfs(currStr + ")", left, right - 1, res);
    }
  }
}
