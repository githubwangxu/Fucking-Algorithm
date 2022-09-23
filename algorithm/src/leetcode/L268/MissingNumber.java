package leetcode.L268;

public class MissingNumber {
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int sum = n / 2 == 0
        ? n / 2 * (n + 1)
        : n / 2 * (n + 1) + n / 2 + 1;
    for (int num : nums) {
      sum -= num;
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] nums = {0,2,3};
    System.out.println(new MissingNumber().missingNumber(nums));
  }
}
