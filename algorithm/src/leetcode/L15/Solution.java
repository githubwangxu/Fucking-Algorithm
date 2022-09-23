package leetcode.L15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/11 15:09
 **/
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return null;
    }
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int i = 0;
    int n = nums.length;
    while (i < n) {
      //没有和为0的可能了，直接返回
      if (nums[i] > 0) {
        return result;
      }
      int left = i + 1;
      int right = n - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (nums[i] + sum > 0) {
          right--;
        }
        if (nums[i] + sum < 0) {
          left++;
        }
        if (nums[i] + sum == 0) {
          List<Integer> subResult = new ArrayList<>();
          subResult.add(nums[i]);
          subResult.add(nums[left]);
          subResult.add(nums[right]);
          result.add(subResult);

          left++;
          //判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
          while (left < right && nums[left - 1] == nums[left]) {
            left++;
          }

          right--;
          while (left < right && nums[right + 1] == nums[right]) {
            right--;
          }
        }
      }
      i++;
      while (i < n && nums[i - 1] == nums[i]) {
        i++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(new Solution().threeSum(nums));
  }
}
