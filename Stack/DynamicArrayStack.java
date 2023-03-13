package Stack;

public class DynamicArrayStack {
  protected int capacity;
  public static final int CAPACITY = 16;
  public static int MINCAPACITY = 1 << 15;
  protected int[] stackRep;
  protected int top = -1;

  public DynamicArrayStack() {
    this(CAPACITY);
  }

  public DynamicArrayStack(int cap) {
    capacity = cap;
    stackRep = new int[capacity];
  }

  public int size() {
    return (top + 1);
  }

  public boolean isEmpty() {
    return (top < 0);
  }

  public void push(int data) throws Exception {
    if (size() == capacity)
      expand();
    stackRep[++top] = data;
  }

  private void expand() {
    int length = size();
    int[] newstack = new int[length << 1];
    System.arraycopy(stackRep, 0, newstack, 0, length);
    stackRep = newstack;
    this.capacity = this.capacity << 1;
  }

  private void shrink() {
    int length = top + 1;
    if (length <= MINCAPACITY || top << 2 >= length)
      return;
    length = length + (top << 1);
    if (top < MINCAPACITY)
      length = MINCAPACITY;
    int[] newStack = new int[length];
    System.arraycopy(stackRep, 0, newStack, 0, top + 1);
    stackRep = newStack;
    capacity = length;
  }

  public int top() throws Exception {
    if (isEmpty())
      throw new Exception("Stack is empty.");
    return stackRep[top];
  }

  public int pop() throws Exception {
    int data;
    if (isEmpty())
      throw new Exception("Stack is empty.");
    data = stackRep[top];
    stackRep[top--] = Integer.MIN_VALUE;
    shrink();
    return data;
  }

  public String toString() {
    String s;
    s = "[";
    if (size() > 0)
      s += stackRep[0];
    if (size() > 1)
      for (int i = 1; i <= size() - 1; i++) {
        s += ", " + stackRep[i];
      }
    return s + "]";
  }

}
