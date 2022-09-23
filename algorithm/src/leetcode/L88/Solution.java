package leetcode.L88;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/13 02:11
 **/
public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
    int[] result = new int[m + n];
    int i = 0, j = 0, k = 0;
    while (i < m || j < n) {
      int num1 = i < m ? nums1[i] : Integer.MAX_VALUE;
      int num2 = j < n ? nums2[j] : Integer.MAX_VALUE;
      if (num1 < num2) {
        result[k++] = num1;
        i++;
      } else {
        result[k++] = num2;
        j++;
      }
    }
    for (int index = 0; index < m + n; index++) {
      nums1[index] = result[index];
    }
  }
}
