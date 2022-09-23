package leetcode.L4;

public class FindMedianSortedArrays {
  public static void main(String[] args) {
    int[] a = {1,2};
    int[] b = {3,4};
    System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(a, b));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int numCount = nums1.length + nums2.length;
    if (numCount == 0) {
      return 0;
    }
    double targetMiddleNum1 = 0, targetMiddleNum2 = 0;
    int index1 = 0, index2 = 0;
    int indexAfterSort = 0;

    while (true) {
      int target;
      int n1 = index1 < nums1.length ? nums1[index1] : Integer.MAX_VALUE;
      int n2 = index2 < nums2.length ? nums2[index2] : Integer.MAX_VALUE;
      if (n1 <= n2) {
        target = nums1[index1];
        index1++;
      } else {
        target = nums2[index2];
        index2++;
      }
      if (indexAfterSort == numCount / 2 - 1) {
        targetMiddleNum1 = target;
      }
      if (indexAfterSort == numCount / 2) {
        targetMiddleNum2 = target;
        break;
      }
      indexAfterSort++;
    }
    return numCount % 2 == 1 ? targetMiddleNum2 : (targetMiddleNum2 + targetMiddleNum1) / 2;
  }
}
