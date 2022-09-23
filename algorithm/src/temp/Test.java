package temp;

import java.util.HashMap;

public class Test {
  public static void main(String[] args) {
    String t1 = "aa";
    isSame(t1);
    StringBuilder builder = new StringBuilder();
    builder.toString();
    HashMap<String, String> hashMap = new HashMap<>();

  }

  public static boolean isSame(String str) {
    if (str.isEmpty()) {
      return false;
    }

    StringBuilder revertStr = new StringBuilder(str);
    revertStr.reverse();
    String rStr = revertStr.toString();

    System.out.println("result = " + str.equals(rStr));

    return rStr.equals(str);

  }
}
