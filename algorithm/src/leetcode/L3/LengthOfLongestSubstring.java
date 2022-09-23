package leetcode.L3;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/5 03:29
 **/
public class LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    if (s.length() == 0) {
      return 0;
    }
    String longestSubstring = "";
    for (int i = 0; i < s.length(); i++) {
      String str = s.substring(i, i + 1);
      if (longestSubstring.contains(str)) {
        maxLength = Math.max(maxLength, longestSubstring.length());
        longestSubstring = longestSubstring.substring(longestSubstring.indexOf(str) + 1) + str;
        continue;
      }
      longestSubstring = longestSubstring + str;
    }
    return  Math.max(maxLength, longestSubstring.length());
  }

  public static void main(String[] args) {
    String st = "abca";
    System.out.println(st.indexOf("a"));
    System.out.println(st.substring(0));
  }
}
