package leetcode.L72;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/13 17:37
 **/
public class Solution {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    if (m * n == 0) {
      return Math.max(m, n);
    }
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j < n + 1; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i < m + 1; i++)
      for (int j = 1; j < n + 1; j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int insertStep = dp[i][j - 1];
          int deleteStep = dp[i - 1][j];
          int replaceStep = dp[i - 1][j - 1];
          dp[i][j] = 1 + Math.min(insertStep, Math.min(deleteStep, replaceStep));
        }
      }
    return dp[m][n];
  }

  public static void main(String[] args) {
    String w1= "horse";
    String w2= "ros";

    System.out.println(new Solution().minDistance(w1, w2));
  }
}
