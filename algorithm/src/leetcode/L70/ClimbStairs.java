package leetcode.L70;

public class ClimbStairs {
  public int climbStairs(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    return climbStairs(n - 1) + climbStairs(n - 2);
  }


  public static void main(String[] args) {
    System.out.println(new ClimbStairs().climbStairs(1));
    System.out.println(new ClimbStairs().climbStairs(2));
    System.out.println(new ClimbStairs().climbStairs(3));
    System.out.println(new ClimbStairs().climbStairs(4));


  }

}
