/**
 * @author Junhao Wang
 * @date 06/07/2019
 */

public class ConnectedComponent {
  private boolean[] marked;
  private int[] id;  // component id for each vertex
  private int count; // number of components

  public ConnectedComponent(Graph G) {
    marked = new boolean[G.V()];
    id = new int[G.V()];
    for (int s = 0; s < G.V(); s += 1) {
      if (marked[s] == false) {
        dfs(G, s);
        count += 1;
      }
    }
  }

  public void dfs(Graph G, int v) {
    marked[v] = true;
    id[v] = count;
    for (int w : G.adj(v)) {
      if (marked[w] == false) {
        dfs(G, w);
      }
    }
  }

  public boolean connected(int v, int w) {
    return id[v] == id[w];
  }

  public int id(int v) {
    return id[v];
  }

  public int count() {
    return count;
  }

}
