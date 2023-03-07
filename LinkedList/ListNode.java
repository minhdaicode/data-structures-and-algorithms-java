package LinkedList;

public class ListNode {
  public int data;
  public ListNode next;

  public ListNode() {
    next = null;
    data = Integer.MIN_VALUE;
  }

  public ListNode(int data) {
    next = null;
    this.data = data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public ListNode getNext() {
    return this.next;
  }

  public int ListLength(ListNode headNode) {
    int length = 0;
    ListNode currentNode = headNode;
    while (currentNode != null) {
      length++;
      currentNode = currentNode.getNext();
    }
    return length;
  }
}