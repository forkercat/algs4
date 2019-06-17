/**
 * @author Junhao Wang
 * @date 06/07/2019
 */

public class UndirectedCycle {
  private boolean[] marked;
  private boolean hasCycle;

  public UndirectedCycle(Graph G) {
    marked = new boolean[G.V()];
    for (int s = 0; s < G.V(); ++s) {
      if (marked[s] == false) {
        dfs(G, -1, s);
      }
    }
  }

  // u is the previous node of v
  public void dfs(Graph G, int u, int v) { // Note: This is only for undirected graph
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (marked[w] == false) {
        dfs(G, v, w);  // v is not equal to u
      } else if (w != u) { // u - v - w. If w == u, it is not connected but bidirectional.
        hasCycle = true; // can I just return? maybe. but the marked is not completed
      }
    }
  }

  public boolean hasCycle() {
    return hasCycle;
  }
}
