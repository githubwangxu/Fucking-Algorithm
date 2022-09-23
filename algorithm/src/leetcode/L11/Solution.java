package leetcode.L11;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/15 22:51
 **/
public class Solution {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int area = Integer.MIN_VALUE;
    while (left < right) {
      area = Math.max((right - left) * Math.min(height[left], height[right]), area);
      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }
    return area;
  }

  public static void main(String[] args) {
    int[] h = {1,8,6,2,5,4,8,3,7};
    System.out.println(new Solution().maxArea(h));
  }
}
