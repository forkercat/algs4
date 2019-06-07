import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * @author Junhao Wang
 * @date 06/07/2019
 */

public class SymbolGraph {
  private ST<String, Integer> st;  // String -> int
  private String[] keys;           // int -> String
  private Graph G;

  public SymbolGraph(String stream, String sp) {
    st = new ST<String, Integer>();
    In in = new In(stream);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      for (int i = 0; i < a.length; i += 1) {
        if (st.contains(a[i]) == false) {
          st.put(a[i], st.size());
        }
      }
    }
    keys = new String[st.size()];
    for (String name : st.keys()) {
      keys[st.get(name)] = name;
    }
    G = new Graph(st.size()); // builds the graph
    in = new In(stream);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      int v = st.get(a[0]);
      for (int i = 1; i < a.length; i += 1) {
        G.addEdge(v, st.get(a[i]));
      }
    }
  }

  public boolean contains(String s) {
    return st.contains(s);
  }

  public int indexOf(String s) {
    return st.get(s);
  }

  public String nameOf(int v) {
    return keys[v];
  }

  public Graph G() {
    return G;
  }
}
