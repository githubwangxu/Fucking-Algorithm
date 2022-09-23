package leetcode.L191;

public class HammingWeight {
  public int hammingWeight(int n) {
    int cnt = 0;
    while (n != 0) {
      if ((n & 1) != 0) {
        cnt++;
      }
      n = n >>> 2;
    }
    return cnt;
  }

  /**
   * 位运算优化
   *
   * @param n
   * @return
   */
  public int hammingWeight2(int n) {
    int cnt = 0;
    while (n != 0) {
      n &= (n - 1);
      cnt++;
    }
    return cnt;
  }
}
