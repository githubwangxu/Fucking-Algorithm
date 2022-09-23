package leetcode.L26;

public class RemoveDuplicateNum {
  public int removeDuplicates(int[] nums) {
    int head = 0;
    for (int tail = 1; tail < nums.length; tail++) {
      if (nums[tail] != nums[head]) {
        head++;
        nums[head] = nums[tail];
      }
    }
    return head + 1;
  }
}
