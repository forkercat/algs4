import edu.princeton.cs.algs4.StdIn;

/**
 * @author Junhao Wang
 * @date 06/09/2019
 */

public class DegreesOfSeparation {
  public static void main(String[] args) {
    SymbolGraph sg= new SymbolGraph(args[0], args[1]);
    Graph G = sg.G();
    String source = args[2];
    if (sg.contains(source) == false) {
      return;
    }

    int s = sg.indexOf(source);
    BreadthFirstSearch bfs = new BreadthFirstSearch(G, s);

    while (StdIn.isEmpty() == false) {
      String sink = StdIn.readLine();
      if (sg.contains(sink)) {
        int t = sg.indexOf(sink);
        if (bfs.hasPathTo(t)) {
          for (int v : bfs.pathTo(t)) {
            System.out.println("   " + sg.nameOf(v));;
          }
        } else {
          System.out.println("not connected");
        }
      } else {
        System.out.println("not in database.");
      }
    }

  }
}
