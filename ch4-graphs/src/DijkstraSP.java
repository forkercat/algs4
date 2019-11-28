import java.util.*;

/**
 * @author Junhao Wang
 * @date 11/27/2019
 */

public class DijkstraSP {

  private Graph G;
  private int S;

  private double[] distTo;
  private int[] edgeTo;

  private PriorityQueue<Integer> pq; // min heap

  public DijkstraSP(int V, List<Edge> edges, int _S) {
    G = new Graph(V, edges);
    S = _S;
    pq = new PriorityQueue<>((o1, o2) -> {
      return (int) (distTo[o1] - distTo[o2]);
    });
    shortestPath();
  }

  private void shortestPath() {
    distTo = new double[G.V];
    edgeTo = new int[G.V];
    Set<Integer> pollSet = new HashSet<>();
    // init
    for (int v = 0; v < G.V; ++v) {
      distTo[v] = (v == S) ? 0 : Double.MAX_VALUE; // distTo[S] = 0
      edgeTo[v] = -1;
      pq.offer(v);
    }

    while (pq.size() > 0) {
      int v = pq.poll();
      pollSet.add(v);
      relax(v, pollSet);
    }
  }

  private void relax(int v, Set<Integer> pollSet) {
    for (int w : G.adj.get(v)) {
      if (pollSet.contains(w)) continue;
      if (distTo[v] + G.weight[v][w] < distTo[w]) {
        distTo[w] = distTo[v] + G.weight[v][w];
        edgeTo[w] = v;
        pq.remove(w); // bad performance
        pq.offer(w);
        // https://stackoverflow.com/questions/12719066/priority-queue-remove-complexity-time
        // To get a better performance, you need to implement the heap by yourself with a hash map that we can find the object in O(1) time.
      }
    }
  }

  public double distTo(int v) {
    return distTo[v];
  }

  public int edgeTo(int v) {
    return edgeTo[v];
  }

  private class Graph {

    private final int V;
    private List<List<Integer>> adj;
    private double[][] weight;

    public Graph(int _V, List<Edge> edges) {
      V = _V;
      adj = new ArrayList<>();
      // init
      for (int i = 0; i < V; ++i) {
        adj.add(new ArrayList<>());
      }
      // edges
      weight = new double[V][V];
      for (Edge e : edges) {
        List<Integer> list = adj(e.from);
        list.add(e.to);
        weight[e.from][e.to] = e.weight;
      }
    }

    public List<Integer> adj(int v) {
      return adj.get(v);
    }

  }

  private static class Edge {
    int from;
    int to;
    double weight;
    Edge(int _from, int _to, double _weight) {
      from = _from;
      to = _to;
      weight = _weight;
    }

    @Override
    public String toString() {
      return from + " -> " + to + "(" + weight + ")";
    }
  }


  public static void main(String[] args) {
    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge(0, 1, 2));
    edges.add(new Edge(0, 2, 1));
    edges.add(new Edge(1, 2, 5));
    edges.add(new Edge(1, 3, 11));
    edges.add(new Edge(3, 4, 2));
    edges.add(new Edge(1, 4, 3));
    edges.add(new Edge(4, 2, 1));
    edges.add(new Edge(2, 5, 15));
    edges.add(new Edge(4, 5, 4));
    edges.add(new Edge(4, 6, 5));
    edges.add(new Edge(6, 5, 1));
    edges.add(new Edge(6, 3, 1));

    DijkstraSP dsp = new DijkstraSP(7, edges, 0);
    for (int v = 0; v < 7; ++v) {
      System.out.print("edgeTo[" + v + "]" + " = " + dsp.edgeTo(v) + "    ");
      System.out.print("distTo[" + v + "]" + " = " + dsp.distTo(v));
      System.out.println();
    }
  }
}



