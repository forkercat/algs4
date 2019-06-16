import java.util.NoSuchElementException;

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

  public boolean isEmpty() {
    return size(root) == 0;
  }

  public Key min() {
    if (isEmpty()) throw new NoSuchElementException();
    Node x = min(root);
    return x.key;
  }

  private Node min(Node x) {
    if (x.left == null) return x;
    return min(x.left);
  }

  /**
   * Nice method to ponder
   */
  public Key floor(Key key) {  // consider a right leaning tree 1 - 2 - 3, and key is 0, it should return null
    Node x = floor(root, key);
    if (x == null) throw new NoSuchElementException();
    return x.key;
  }

  private Node floor(Node x, Key key) {
    if (x == null) {
      return null;
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) { // left => must
      return floor(x.left, key);
    } else if (cmp > 0) { // right => could be
      Node ret = floor(x.right, key);
      if (ret == null) return x; // does not exist
      else return ret;
    } else { // equal
      return x;
    }
  }

  // ceil is similar, just flip two sides.

  public Key select(int k) { // key 0 ~ size - 1
    if (k < 0 || k >= size()) throw new IllegalArgumentException();
    Node x = select(root, k);
    return x.key;
  }

  // Visualization: https://bloggg-1254259681.cos.na-siliconvalley.myqcloud.com/1fts4.jpg
  private Node select(Node x, int k) { // it can't be null
    if (x == null) return null;
    int t = size(x.left);
    if (k < t) { // left
      return select(x.left, k);
    } else if (k > t) { // right
      return select(x.right, k - t - 1);
    } else {
      return x;
    }
  }

  // 666
  public int rank(Key key) {
    return rank(root, key);
  }

  private int rank(Node x, Key key) {
    if (x == null) return -1; // does not exist
    int cmp = key.compareTo(x.key);
    if (cmp < 0) { // left
      return rank(x.left, key);
    } else if (cmp > 0) { // right
      return size(x.left) + 1 + rank(x.right, key);
    } else {
      return size(x.left);
    }
  }



  /**
   * Iterative version
   */
  public Value getIter(Key key) {
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

  public void putIter(Key key, Value val) {
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
