package leetcode.L13;

import java.util.HashMap;

public class RomanToInt {
  private static HashMap<Character, Integer> valueMap = new HashMap<>();

  static {
    valueMap.put('I', 1);
    valueMap.put('V', 5);
    valueMap.put('X', 10);
    valueMap.put('L', 50);
    valueMap.put('C', 100);
    valueMap.put('D', 500);
    valueMap.put('M', 1000);
  }

  public int romanToInt(String s) {
    int sum = 0;
    int preNum = valueMap.get(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      int num = valueMap.get(s.charAt(i));
      if (preNum < num) {
        sum -= preNum;
      } else {
        sum += preNum;
      }
      preNum = num;
    }
    sum += preNum;
    return sum;
  }

  public static void main(String[] args) {
    String a = "LVIII";
    System.out.println(new RomanToInt().romanToInt(a));

  }
}
