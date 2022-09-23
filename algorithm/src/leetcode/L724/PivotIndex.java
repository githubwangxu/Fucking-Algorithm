package leetcode.L724;

public class PivotIndex {
  public static void main(String[] args) {
    int[] a = {1, 7, 3, 6, 5, 6};
    System.out.println(pivotIndex(a));

    int[] b = {1, 2, 3};
    System.out.println(pivotIndex(b));

    int[] c = {2, 1,-1};
    System.out.println(pivotIndex(c));

  }

  public static int pivotIndex(int[] nums) {
    int rightSum = 0, leftSum = 0;
    for (int i : nums) {
      rightSum += i;
    }

    for (int i = 0; i < nums.length; i++) {
      rightSum -= nums[i];
      if (leftSum == rightSum) {
        return i;
      }
      leftSum += nums[i];
    }
    return -1;
  }
}
