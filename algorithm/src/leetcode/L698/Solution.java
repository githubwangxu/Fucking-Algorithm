package leetcode.L698;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/20 23:36
 **/
public class Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % k != 0) {
      return false;
    }
    int avg = sum / k;
    for (int i : nums) {
      if (i > avg) {
        return false;
      }
    }
    return true;
  }
}
