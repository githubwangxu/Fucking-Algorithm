package leetcode.L33;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/13 01:53
 **/
public class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    //每次先找到有顺序的一边，然后从有序的一边找，有序的一边没有的话，再去分割无序的一边
    while (left <= right) {
      int mid = ((right - left) >> 1) + left;
      if (nums[mid] == target) {
        return mid;
      }
      //左边有序
      if (nums[left] <= nums[mid]) {
        //目标的元素在有序的队列中
        if (nums[left] <= target && nums[mid] > target) {
          right = mid - 1;
        } else {
          //去右边找
          left = mid + 1;
        }
      }



      else {
        if (nums[mid] < target && nums[right] >= target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {

//    int[] nums = {4,5,6,7,8,1,2,3};
    int[] nums = {3,1};
//    System.out.println(new Solution().search(nums, 9));

    for (int target : nums) {
      System.out.println(new Solution().search(nums, target));
    }


  }

}
