package leetcode.L215M;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/17 22:32
 **/
public class Solution {
  //从小到大排序，第k大就是下标为 n-k 的元素
  public int findKthLargest(int[] nums, int k) {
    int index = findKth(nums, nums.length - k, 0, nums.length - 1);
    return nums[index];
  }

  public int findKth(int[] nums, int target, int left, int right) {
    int pivotIndex = partition(nums, left, right);
    if (pivotIndex == target) {
      return pivotIndex;
    }
    if (pivotIndex < target) {
      return findKth(nums, target, pivotIndex + 1, right);
    } else {
      return findKth(nums, target, left, pivotIndex - 1);
    }
  }

  public int partition(int[] nums, int low, int high) {

//    方法一：随机数字改进
//    int randomIndex = low + random.nextInt(high - low + 1);
//    swap(nums, low, randomIndex);

    //方法二：三数取中
    int m = low + (high - low) / 2;
    if (nums[low] > nums[high]) {
      swap(nums, low, high);
    }
    if (nums[m] > nums[high]) {
      swap(nums, m, high);
    }
    if (nums[m] > nums[low]) {
      swap(nums, low, m);
    }
    int pivotKey = nums[low];
    while (low < high) {
      while (low < high && nums[high] >= pivotKey)
        high--;
      nums[low] = nums[high];
      while (low < high && nums[low] < pivotKey)
        low++;
      nums[high] = nums[low];
    }
    nums[low] = pivotKey;
    return low;
  }

  public void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
