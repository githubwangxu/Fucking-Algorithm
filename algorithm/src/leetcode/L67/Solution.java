package leetcode.L67;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/18 09:53
 **/
public class Solution {
  public String addBinary(String a, String b) {
    StringBuilder builder = new StringBuilder();

    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i > -1 || j > -1) {
      int m = i > -1 ? a.charAt(i) - 48 : 0;
      int n = j > -1 ? b.charAt(j) - 48 : 0;
      i--;
      j--;

      int result = m + n + carry;
      carry = result / 2;
      result = result % 2;
      builder.append(result);
    }
    if (carry > 0) {
      builder.append(carry);
    }
    return builder.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().addBinary("1010", "1011"));
  }
}
