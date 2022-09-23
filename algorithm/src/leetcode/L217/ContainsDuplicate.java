package leetcode.L217;

import java.util.HashSet;

public class ContainsDuplicate {
  private HashSet<Integer> existedNum = new HashSet<>();

  public boolean containsDuplicate(int[] nums) {
    for (int i : nums) {
      if (existedNum.contains(i)) {
        return true;
      }
      existedNum.add(i);
    }
    return false;
  }
}
