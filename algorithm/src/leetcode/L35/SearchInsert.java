package leetcode.L35;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/5 08:20
 **/
public class SearchInsert {
  public int searchInsert(int[] nums, int target) {
    int head = 0;
    int tail = nums.length - 1;
    while (head < tail) {
      int middle = (head + tail) / 2;
      if (nums[middle] <= target) {
        head = middle + 1;
      } else {
        tail = middle - 1;
      }
    }
    return head;
  }
}
