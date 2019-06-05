import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Junhao Wang
 * @date 06/05/2019
 */

public class Graph {
  private final int V;          // number of vertices
  private int E;                // number of edges
  private List<Integer>[] adj;  // adjacency lists

  public Graph(int V) {
    this.V = V;
    adj = (LinkedList<Integer>[]) new LinkedList[V];
    for (int v = 0; v < V; v += 1) {
      adj[v] = new LinkedList<Integer>();
    }
  }

  public Graph(In in) {
    this(in.readInt()); // read V
    int E = in.readInt(); // read E
    for (int i = 0; i < E; i += 1) {
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  public int V() { return V; }
  public int E() { return E; }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
    E += 1;
  }

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }
}
