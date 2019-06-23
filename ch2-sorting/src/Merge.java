/**
 * @author Junhao Wang
 * @date 06/22/2019
 */

public class Merge {

  private static int[] aux;

  public static void sort(int[] a) {
    aux = new int[a.length];
    sort(a, 0, a.length - 1);
  }

  private static void sort(int[] a, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
  }

  private static void merge(int[] a, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; ++k) {
      aux[k] = a[k];
    }
    for (int k = lo; k <= hi; ++k) {
      if (i > mid)              a[k] = aux[j++];
      else if (j > hi)          a[k] = aux[i++];
      else if (aux[j] < aux[i]) a[k] = aux[j++];
      else                      a[k] = aux[i++];
    }
  }

  public static void sortBottomUp(int[] a) {
    int n = a.length;
    aux = new int[n];
    for (int len = 1; len < n; len *= 2) {
      for (int lo = 0; lo < n - len; lo += len + len) {
        int mid = lo + len - 1;
        int hi = Math.min(lo + len + len - 1, n - 1);
        merge(a, lo, mid, hi);
      }
    }
  }
}
