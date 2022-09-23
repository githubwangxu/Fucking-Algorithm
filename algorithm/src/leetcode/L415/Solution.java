package leetcode.L415;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/6 16:04
 **/
public class Solution {
  public String addStrings(String num1, String num2) {
    char[] num1Chars = num1.toCharArray();
    char[] num2Chars = num2.toCharArray();
    StringBuilder result = new StringBuilder();
    int carry = 0;
    int i = num1Chars.length - 1, j = num2Chars.length - 1;
    while (i > -1 || j > -1) {
      int a = i <= -1 ? 0 : num1Chars[i] - 48;
      int b = j <= -1 ? 0 : num2Chars[j] - 48;
      int count = a + b + carry;
      carry = count / 10;
      result.append(count % 10);
      i--;
      j--;
    }
    if (carry > 0) {
      result.append(carry);
    }
    //最后reverse可以提升效率
    return result.reverse().toString();
  }

  public static void main(String[] args) {
    String a = "11";
    String b = "123";
    System.out.println(new Solution().addStrings(a, b));
  }
}
