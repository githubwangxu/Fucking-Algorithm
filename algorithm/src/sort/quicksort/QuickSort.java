package sort.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/17 20:48
 **/
public class QuickSort {

  private static final Random random = new Random(System.currentTimeMillis());

  public static void main(String[] args) {
    int[] nums = {4, 5, 11, 9, 10};
    new QuickSort().quickSort(nums);
    System.out.println(Arrays.toString(nums));
  }

  public void quickSort(int[] nums) {
    qSort(nums, 0, nums.length - 1);
  }

  public void qSort(int[] nums, int low, int high) {
    while (low < high) {
      int pivot = partition(nums, low, high);
      qSort(nums, low, pivot - 1);
      low = pivot + 1;
    }
  }

  /**
   * 整理 low 到 high区间的元素，选取一个枢纽key，整理完成之后可以确定枢纽key的位置
   *
   * @param nums
   * @param low
   * @param high
   * @return
   */
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
