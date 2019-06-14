/**
 * @author Junhao Wang
 * @date 06/13/2019
 */

public class BST<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value val;
    private Node left, right;
    private int n;

    public Node(Key key, Value val, int n) {
      this.key = key;
      this.val = val;
      this.n = n;
    }
  }

  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if (x == null) return 0;
    return x.n;
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) { // left
      return get(x.left, key);
    } else if (cmp > 0) { // right
      return get(x.right, key);
    } else { // found
      return x.val;
    }
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
  }

  private Node put(Node x, Key key, Value val) {
    if (x == null) return new Node(key, val, 1);
    int cmp = key.compareTo(x.key);
    if (cmp < 0) { // left
      x.left = put(x.left, key, val);
    } else if (cmp > 0) { // right
      x.right = put(x.right, key, val);
    } else {
      x.val = val; // update the value
    }

    x.n = size(x.left) + size(x.right) + 1;
    return x;
  }


  /**
   * Iterative version
   */
  public Value get_iter(Key key) {
    Node x = root;
    while (x != null) {
      int cmp = key.compareTo(x.key);
      if (cmp < 0) { // left
        x = x.left;
      } else if (cmp > 0) { // right
        x = x.right;
      } else { // found
        return x.val;
      }
    }
    return null; // not found
  }

  public void put_iter(Key key, Value val) {
    Node x = root;
    while (x != null) {
      int cmp = key.compareTo(x.key);
      if (cmp < 0) { // left
        if (x.left != null) x = x.left;
        else { x.left = new Node(key, val, 1); return; }
      } else if (cmp > 0) { // right
        if (x.right != null) x = x.right;
        else { x.right = new Node(key, val, 1); return; }
      } else { // found
        x.val = val;
        return;
      }
    }
  }

}
