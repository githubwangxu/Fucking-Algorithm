package leetcode.L704;

/**
 * 二分查找
 */
public class Search {

  /**
   * 普通的查找
   * @param nums
   * @param target
   * @return
   */
  public int search(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (target == nums[i]) {
        return i;
      }
    }
    return -1;
  }

  public int binSearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    //target不在给定范围内
    if (target < nums[left] || target > nums[right]) {
      return -1;
    }

    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] == target) {
        return middle;
      }
      if (nums[middle] < target) {
        left = middle + 1;
      }
      if (nums[middle] > target) {
        right = middle - 1;
      }
    }
    return -1;
  }
}
