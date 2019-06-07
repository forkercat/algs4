import edu.princeton.cs.algs4.Queue;

import java.util.Stack;

/**
 * @author Junhao Wang
 * @date 06/06/2019
 */

public class BreadthFirstSearch {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public BreadthFirstSearch(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    bfs(G, s);
  }

  private void bfs(Graph G, int s) {
    Queue<Integer> queue = new Queue<>();
    marked[s] = true;
    queue.enqueue(s);
    while (queue.isEmpty() == false) {
      int v = queue.dequeue();
      for (int w : G.adj(v)) {
        if (marked[w] == false) {
          edgeTo[w] = v;
          marked[w] = true;
          queue.enqueue(w);
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (hasPathTo(v) == false) {
      return null;
    }
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }
}
