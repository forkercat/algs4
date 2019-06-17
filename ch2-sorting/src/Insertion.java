/**
 * @author Junhao Wang
 * @date 06/17/2019
 */

public class Insertion {

  public static void sort(int[] a) {
    int n = a.length;
    for (int i = 1; i < n; ++i) {
      for (int j = i; j > 0 && a[j - 1] > a[j]; --j) {
        swap(a, j - 1, j);
      }
    }
  }

  public static void sort2(int[] a) {
    int n = a.length;
    for (int i = 1; i < n; ++i) {
      int temp = a[i];
      int j;
      for (j = i; j > 0 && a[j - 1] > a[j]; ++j) {
        a[j] = a[j - 1];
      }
      a[j - 1] = temp;
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
