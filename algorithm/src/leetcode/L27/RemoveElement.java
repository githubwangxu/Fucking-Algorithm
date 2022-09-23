package leetcode.L27;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/5 21:33
 **/
public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int head = 0, tail = nums.length - 1;
    while (head <= tail) {
      while (head < nums.length && nums[head] != val) {
        head++;
      }
      while (tail > -1 && nums[tail] == val) {
        tail--;
      }
      if (head > tail) {
        return tail + 1;
      }
      nums[head] = nums[tail];
      nums[tail] = val;
      head++;
      tail--;
    }
    return tail + 1;
  }

  public static void main(String[] args) {
    int[] arr = {3, 2, 2, 3};
    int[] arr2 = {3};

    System.out.println(new RemoveElement().removeElement(arr2, 3));

  }
}
