package leetcode.L278;

public class FirstBadVersion {
  public int firstBadVersion(int n) {
    if (n == 1) {
      return n;
    }
    int left = 1;
    int right = n;
    int middle = n / 2;
    while (left < right) {
      if (isBadVersion(middle)) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
      middle = (left + right) / 2;
    }
    return left;
  }

  public boolean isBadVersion(int version) {
    return true;
  }
}
