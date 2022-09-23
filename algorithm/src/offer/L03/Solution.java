package offer.L03;

import java.util.HashSet;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/15 23:03
 **/
public class Solution {
  public int findRepeatNumber(int[] nums) {
    HashSet<Integer> existedNum = new HashSet<>();
    for (int num : nums) {
      if (existedNum.contains(num)) {
        return num;
      }
      existedNum.add(num);
    }
    return -1;
  }
}
