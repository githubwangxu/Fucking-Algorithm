package leetcode.L205;

import java.util.HashMap;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/16 09:12
 **/
public class Solution {
  public boolean isIsomorphic(String s, String t) {
    int m = s.length();
    int n = t.length();
    if (m != n) {
      return false;
    }
    HashMap<Character, Character> hashMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character ch = hashMap.get(s.charAt(i));
      if (ch != null && t.charAt(i) != ch) {
        return false;
      }
      if (ch == null && hashMap.containsValue(t.charAt(i))) {
        return false;
      }
      if (ch == null) {
        hashMap.put(s.charAt(i), t.charAt(i));
      }
    }
    return true;
  }
}
