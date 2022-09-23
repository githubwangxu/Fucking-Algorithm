package leetcode.L409;

import java.util.HashMap;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/20 22:05
 **/
public class Solution {
  public int longestPalindrome(String s) {
    HashMap<Character, Integer> counter = new HashMap<>(s.length());
    for (int i = 0; i < s.length(); i++) {
      counter.merge(s.charAt(i), 1, Integer::sum);
    }
    int longestLength = 0;
    int odd = 0;
    for (int count : counter.values()) {
      longestLength += count / 2 * 2;
      if (odd == 0 && count % 2 == 1) {
        odd = 1;
      }
    }
    return longestLength + odd;
  }
}
