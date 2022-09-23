package leetcode.L392;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/16 08:46
 **/
public class Solution {
  // s is subsequence of t


  public static void main(String[] args) {
    System.out.println(new Solution1().isSubsequence("abc","ahbgdc"));
  }
}

class Solution1 {
  public boolean isSubsequence(String s, String t) {
    int subIndex = 0;
    int index = 0;
    while (subIndex < s.length() && index < t.length()){
      if (s.charAt(subIndex) == t.charAt(index)){
        subIndex ++;
      }
      index ++;
    }
    return subIndex == s.length();
  }
}
