import java.util.Iterator;

/**
 * @date 05/24/2019
 * @author Junhao Wang
 */

public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] a = (Item[]) new Object[1];
  private int n = 0;

  public boolean isEmpty() { return n == 0; }
  public int size() { return n; }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < n; i += 1) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item) {
    if (n == a.length) resize(2 * a.length);
    a[n++] = item;
  }

  public Item pop() {
    Item item = a[--n];
    a[n] = null;
    if (n > 0 && n == a.length / 4) resize(a.length / 2);
    return item;
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = n - 1;
    public boolean hasNext() { return i >= 0; }
    public Item next() { return a[i--]; }
    public void remove() {  }
  }
}
