package LinkedList;

public class DoublyLinkedList {
  private DLLNode head;
  private DLLNode tail;
  private int length;

  public DoublyLinkedList() {
    head = new DLLNode(Integer.MIN_VALUE, null, null);
    tail = new DLLNode(Integer.MIN_VALUE, null, null);
    head.setNext(tail);
    length = 0;
  }

  public int get(int position) {
    return Integer.MIN_VALUE;
  }

  public int getPosition(int data) {
    DLLNode temp = head;
    int pos = 0;
    while (temp != null) {
      if (temp.getData() == data) {
        return pos;
      }
      pos += 1;
      temp = temp.getNext();
    }
    return Integer.MIN_VALUE;
  }

  public int length() {
    return length;
  }

  public void insert(int newValue) {
    DLLNode newNode = new DLLNode(newValue, null, head.getNext());
    newNode.getNext().setPrev(newNode);
    head = newNode;
    length += 1;
  }

  public void insert(int data, int position) {
    if (position < 0) {
      position = 0;
    }
    if (position > length) {
      position = length;
    }
    if (head == null) {
      head = new DLLNode(data);
      tail = head;
    } else if (position == 0) {
      DLLNode temp = new DLLNode(data);
      temp.next = head;
      head = temp;
    } else {
      DLLNode temp = head;
      for (int i = 1; i < position; i += 1) {
        temp = temp.getNext();
      }
      DLLNode newNode = new DLLNode(data);
      newNode.next = temp.next;
      newNode.prev = temp;
      newNode.next.prev = newNode;
      temp.next = newNode;
    }
    length += 1;
  }

  public void insertTail(int newValue) {
    DLLNode newNode = new DLLNode(newValue, tail.getPrev(), tail);
    newNode.getPrev().setNext(newNode);
    tail.setPrev(newNode);
    length += 1;
  }

  public void remove(int position) {
    if (position < 0) {
      position = 0;
    }
    if (position >= length) {
      position = length - 1;
    }
    if (head == null) {
      return;
    }
    if (position == 0) {
      head = head.getNext();
      if (head == null)
        tail = null;
    } else {
      DLLNode temp = head;
      for (int i = 0; i < position; i += 1) {
        temp = temp.getNext();
      }
      temp.getNext().setPrev(temp.getPrev());
      temp.getPrev().setNext(temp.getNext());
    }
    length += 1;
  }

  public synchronized void removeMatched(DLLNode node) {
    if (head == null)
      return;
    if (node.equals(head)) {
      head = head.getNext();
      if (head == null)
        tail = null;
      return;
    }
    DLLNode p = head;
    while (p != null) {
      if (node.equals(p)) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        return;
      }
    }
  }

  public int removeHead() {
    if (length == 0)
      return Integer.MIN_VALUE;
    DLLNode save = head.getNext();
    head.setNext(save.getNext());
    save.getNext().setPrev(head);
    length -= 1;
    return save.getData();
  }

  public int removeTail() {
    if (length == 0)
      return Integer.MIN_VALUE;
    DLLNode save = tail.getPrev();
    tail.setPrev(save.getPrev());
    save.getPrev().setNext(tail);
    length -= 1;
    return save.getData();
  }

  public String toString() {
    String result = "[";
    if (length == 0)
      return result;
    result = "[" + head.getNext().getData();
    DLLNode temp = head.getNext().getNext();
    while (temp != tail) {
      result += "," + temp.getData();
      temp = temp.getNext();
    }
    return result + "]";
  }

  public void clearList() {
    head = null;
    tail = null;
    length = 0;
  }
}
