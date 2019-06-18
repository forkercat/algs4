/**
 * @author Junhao Wang
 * @date 06/17/2019
 */

public class Shell {

  /*
  h = 4
  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
  L  E  E  A  M  H  L  E  P  S  O  L  T  S  X  R
  L-----------M-----------P-----------T
     E-----------H-----------S-----------S
        E-----------L-----------O-----------X
           A-----------E-----------L-----------R
              i                       i
 j-h          j          j-h          j
             h=4
            j >= h
  */
  public static void sort(int[] a) {
    int n = a.length;
    int h = 1;
    while (h < n / 3) h = 3 * h + 1;  // 1, 4, 13, 40, 121, 364, 1093, ...
    while (h >= 1) {
      // h-sort the array.
      for (int i = h; i < n; ++i) { // insert a[i] among a[i-h], a[i-2*h], a[i-3*h]
        for (int j = i; j >= h && a[j - h] > a[j]; j -= h) {

        }
      }
      h = h / 3;
    }
  }
}
