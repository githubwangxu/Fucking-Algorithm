package leetcode.L17;

import java.util.*;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/7 06:41
 **/
public class Solution {
  private static HashMap<Character, List<String>> digitToChars = new HashMap<>();

  static {
    digitToChars.put('2', Arrays.asList("a", "b", "c"));
    digitToChars.put('3', Arrays.asList("d", "e", "f"));
    digitToChars.put('4', Arrays.asList("g", "h", "i"));
    digitToChars.put('5', Arrays.asList("j", "k", "l"));
    digitToChars.put('6', Arrays.asList("m", "n", "o"));
    digitToChars.put('7', Arrays.asList("p", "q", "r", "s"));
    digitToChars.put('8', Arrays.asList("t", "u", "v"));
    digitToChars.put('9', Arrays.asList("w", "x", "y", "z"));
  }

  public List<String> letterCombinations(String digits) {
    List<String> result = new LinkedList<>();
    if (digits.length() < 1) {
      return result;
    }
    for (int i = 0; i < digits.length(); i++) {
      char ch = digits.charAt(i);
      List<String> newChars = digitToChars.get(ch);
      if (result.isEmpty()) {
        result.addAll(newChars);
        continue;
      }
      int resultSize = result.size();
      for (int j = 0; j < resultSize; j++) {
        String existStr = result.remove(0);
        for (int k = 0; k < newChars.size(); k++) {
          result.add(existStr + newChars.get(k));
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> result = new Solution().letterCombinations("");
    System.out.println(Arrays.toString(result.toArray()));
  }
}
