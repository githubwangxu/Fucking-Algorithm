package offer.L42;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/15 23:07
 **/
public class Solution {
  //这样写太复杂了
  public int maxSubArray(int[] nums) {
    int length = nums.length;
    int max = Integer.MIN_VALUE;
    int[][] dp = new int[length][length];
    for (int i = 0; i < length; i++) {
      dp[i][i] = nums[i];
      max = Math.max(dp[i][i], max);
      for (int j = i + 1; j < length; j++) {
        dp[i][j] = dp[i][j - 1] + nums[j];
        max = Math.max(dp[i][j], max);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(new Solution2().maxSubArray(nums));
  }
}

class Solution2 {
  public int maxSubArray(int[] nums) {
    int pre = 0;
    int max = nums[0];
    for (int num : nums) {
      pre = pre > 0 ? pre + num : num;
      max = Math.max(pre, max);
    }
    return max;
  }
}


