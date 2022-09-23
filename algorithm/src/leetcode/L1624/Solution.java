package leetcode.L1624;

import java.util.HashMap;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/17 16:00
 **/
public class Solution {
  public int maxLengthBetweenEqualCharacters(String s) {
    HashMap<Character, Integer> charToIndex = new HashMap<>();
    int maxLength = -1;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (charToIndex.containsKey(ch)) {
        maxLength = Math.max(maxLength, i - charToIndex.get(i) - 1);
      } else {
        charToIndex.put(ch, i);
      }
    }
    return maxLength;
  }
}
