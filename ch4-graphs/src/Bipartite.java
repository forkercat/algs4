/**
 * @author Junhao Wang
 * @date 06/07/2019
 */

public class Bipartite {
  private boolean[] marked;
  private boolean[] color;
  private boolean isBipartite = true; // true: U-V-U  false: U-V-V

  public Bipartite(Graph G) {
    marked = new boolean[G.V()];
    color = new boolean[G.V()];
    for (int s = 0; s < G.V(); ++s) {
      if (marked[s] == false) {
        dfs(G, s);
      }
    }
  }

  public void dfs(Graph G, int v) {
    marked[v] = true;

    for (int w : G.adj(v)) {
      if (marked[w] == false) {
        color[w] = !color[v];
        dfs(G, w);
      } else if (color[v] == color[w]) { // find marked vertex
        isBipartite = false;
      }
    }
  }

  public boolean isBipartite() {
    return isBipartite;
  }
}
