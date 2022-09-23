package leetcode.L165;

public class CompareVersion {
  public int compareVersion(String version1, String version2) {
    String spiltStr = "\\.";
    String[] arrV1 = version1.split(spiltStr);
    String[] arrV2 = version2.split(spiltStr);
    for (int i = 0; i < Math.max(arrV1.length, arrV2.length); i++) {
      int v1 = i < arrV1.length
          ? Integer.parseInt(arrV1[i])
          : 0;
      int v2 = i < arrV2.length
          ? Integer.parseInt(arrV2[i])
          : 0;
      if (v1 < v2) {
        return -1;
      }
      if (v1 > v2) {
        return 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(1 >> 1);
    System.out.println(new CompareVersion().compareVersion("0.01", "1.001"));
  }
}
