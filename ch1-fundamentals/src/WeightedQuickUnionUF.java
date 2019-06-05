import java.util.Arrays;

/**
 * @date 06/04/2019
 * @author Junhao Wang
 */

public class WeightedQuickUnionUF {
  private int[] id;
  private int[] sz; // size of component for roots (size indexed)
  private int count;

  public WeightedQuickUnionUF(int n) {
    count = n;
    id = new int[n];
    for (int i = 0; i < n; i += 1) {
      id[i] = i;
    }
    sz = new int[n];
    for (int i = 0; i < n; i += 1) {
      sz[i] = 1;
    }
    Arrays.sort();
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    while (p != id[p]) {
      p = id[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) return;

    if (sz[i] <= sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
    count -= 1;
  }
}
