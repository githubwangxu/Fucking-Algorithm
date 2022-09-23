package leetcode.L9;

public class Palindrome {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    String str = String.valueOf(x);
    String reverseStr = new StringBuffer(str).reverse().toString();
    return str.equals(reverseStr);
  }

  public static void main(String[] args) {
    int a = 123;
    String str = "123";
//    System.out.println();
    String reverseStr = new StringBuffer(str).reverse().toString();
//    System.out.println(reverseStr);
//    System.out.println(reverseStr.equals(str));

    String newStr = new String("123");
    System.out.println(str.equals(newStr));
  }

}
