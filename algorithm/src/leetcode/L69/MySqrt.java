package leetcode.L69;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/6 13:10
 **/
public class MySqrt {
  public int mySqrt(int x) {
    int left = 1;
    int right = x;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (mid * mid < x) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;

  }
}
