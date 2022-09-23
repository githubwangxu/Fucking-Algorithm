package leetcode.L5;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/12 22:15
 **/
public class Solution {
  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    int beginIndex = 0;
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    char[] charArray = s.toCharArray();
    for (int j = 1; j < len; j++)
      for (int i = 0; i < j; i++) {
        if (charArray[i] != charArray[j]) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }
        if (dp[i][j] && (j - i + 1 > maxLen)) {
          maxLen = j - i + 1;
          beginIndex = i;
        }
      }
    return s.substring(beginIndex, beginIndex + maxLen);
  }
}
