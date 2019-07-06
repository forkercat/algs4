/**
 * @author Junhao Wang
 * @date 07/06/2019
 */

public class RedBlackBST<Key extends Comparable<Key>, Value> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private class Node {
    Key key;
    Value val;
    Node left, right;
    int n;
    boolean color;

    Node(Key key, Value val, int n, boolean color) {
      this.key = key;
      this.val = val;
      this.n = n;
      this.color = color;
    }
  }

  private Node root;


  private void put(Key key, Value val) {
    root = put(root, key, val);
    root.color = BLACK;
  }

  private Node put(Node h, Key key, Value val) {
    if (h == null) {
      return new Node(key, val, 1, RED);
    }
    int cmp = key.compareTo(h.key);
    if (cmp < 0) {
      h.left = put(h.left, key, val);
    } else if (cmp > 0) {
      h.right = put(h.right, key, val);
    } else {
      h.val = val; // just update
    }

    // check red-black (null returns BLACK)
    if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
    if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
    if (isRed(h.left) && isRed(h.right)) flipColors(h);

    // update height
    h.n = size(h.left) + size(h.right) + 1;

    return h;
  }



  //    h
  //   / \
  //      x
  //     / \
  //
  private Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;  // color
    h.color = RED;
    x.n = h.n;          // size: new root's size == old root's size
    h.n = 1 + size(h.left) + size(h.right);
    return x;
  }

  //     h
  //    / \
  //   x
  //  / \
  private Node rotateRight(Node h) {
    Node x = h.left;
    h.right = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.n = h.n;
    h.n = 1 + size(h.left) + size(h.right);
    return x;
  }

  private void flipColors(Node h) {
    h.color = RED;
    h.left.color = BLACK;  // not null
    h.right.color = BLACK; // not null
  }


  private int size(Node x) {
    if (x == null) return 0;
    else return x.n;
  }





  private boolean isRed(Node x) {
    if (x == null) return false;
    else return x.color == RED;
  }





}
