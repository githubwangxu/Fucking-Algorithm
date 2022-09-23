package serarch.s1顺序表查找;

import java.util.List;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/9 20:52
 **/
public class Search {

  /**
   * 顺序查找：就是从第一个开始一直遍历到最后一个
   *
   * @param array 无序的数组
   * @param key   想找的关键字
   * @return
   */
  public static int sequentialSearch(int[] array, int key) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == key) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 有序表查找- 折半查找
   *
   * @param arr
   * @param key
   * @return
   */
  public static int binarySearch(int[] arr, int key) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid =low + ((high - low)>>1);
      if (arr[mid] < key) {
        low = mid + 1;
      } else if (arr[mid] > key) {
        high = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] sortedArr = {0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
    System.out.println(binarySearch(sortedArr, 99));
  }
}
