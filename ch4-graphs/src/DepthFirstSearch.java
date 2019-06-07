import java.util.Stack;

/**
 * @author Junhao Wang
 * @date 06/06/2019
 */

public class DepthFirstSearch {
  private boolean[] marked;
  private int count;
  // extended for paths
  private int[] edgeTo;
  private final int s;  // source

  public DepthFirstSearch(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    count += 1; // visit
    for (int w : G.adj(v)) {
      if (marked[w] == false) {
        edgeTo[w] = v;
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

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (hasPathTo(v) == false) {
      return null;
    }
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[v]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }
}
