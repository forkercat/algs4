/**
 * @author Junhao Wang
 * @date 06/17/2019
 */

public class Selection {
  public static void sort(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; ++i) {
      int min = i;
      for (int j = i + 1; j < n; ++j) {
        if (a[j] < a[min]) min = j;
      }
      swap(a, i, min);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
