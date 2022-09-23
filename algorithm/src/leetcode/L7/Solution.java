package leetcode.L7;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/18 12:23
 **/
public class Solution {
  public int reverse(int x) {
    int res = 0;
    while (x != 0) {
      if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
        return 0;
      }
      int tmp = x % 10;
      res = res * 10 + tmp;
      x /= 10;
    }
    return res;
  }
}
