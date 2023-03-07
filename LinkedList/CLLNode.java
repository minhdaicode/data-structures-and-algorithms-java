package LinkedList;

public class CLLNode {
  public int data;
  public CLLNode next;

  public CLLNode() {
    next = null;
    data = Integer.MIN_VALUE;
  }

  public CLLNode(int data) {
    next = null;
    this.data = data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setNext(CLLNode next) {
    this.next = next;
  }

  public CLLNode getNext() {
    return this.next;
  }
}
