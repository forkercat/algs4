/**
 * @author Junhao Wang
 * @date 06/06/2019
 */

public class DepthFirstSearch {
  private boolean[] marked;
  private int count;

  public DepthFirstSearch(Graph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    count += 1; // visit
    for (int w : G.adj(v)) {
      if (marked[w] == false) {
        dfs(G, w);
      }
    }
  }

  public boolean marked(int v) {
    return marked[v];
  }

  public int count() {
    return count;
  }

}
