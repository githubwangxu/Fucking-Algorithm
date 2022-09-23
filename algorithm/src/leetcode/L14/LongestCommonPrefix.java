package leetcode.L14;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    String commonStr = strs[0];
    int commonStrLastSize = strs[0].length();

    if (commonStr.isEmpty()) {
      return commonStr;
    }

    for (int i = 1; i < strs.length; i++) {
      commonStrLastSize = Math.min(strs[i].length(), commonStrLastSize);

      for (int j = 0; j < commonStrLastSize; j++) {
        if (commonStr.charAt(j) != strs[i].charAt(j)) {
          commonStrLastSize = j;
          break;
        }
      }
      commonStr = commonStr.substring(0, commonStrLastSize);
      if (commonStr.isEmpty()) {
        return commonStr;
      }

    }
    return commonStr;
  }

  public static void main(String[] args) {
//    String[] strs = {"flower", "flower","fl"};
//    System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));

    String st = "abc";
    System.out.println(st.substring(0, 0));


  }
}
