package LinkedList;

public class CircularLinkedList {
  protected CLLNode tail;
  protected int length;

  public CircularLinkedList() {
    tail = null;
    length = 0;
  }

  public void add(int data) {
    addToHead(data);
  }

  public void addToHead(int data) {
    CLLNode temp = new CLLNode(data);
    if (tail == null) {
      tail = temp;
      tail.setNext(tail);
    } else {
      temp.setNext(tail.getNext());
      tail.setNext(temp);
    }
    length++;
  }

  public void addToTail(int data) {
    addToHead(data);
    tail = tail.getNext();
  }

  public int peek() {
    return tail.getNext().getData();
  }

  public int tailPeek() {
    return tail.getData();
  }

  public int removeFromHead() {
    CLLNode temp = tail.getNext();
    if (tail == tail.getNext()) {
      tail = null;
    } else {
      tail.setNext(temp.getNext());
      temp.setNext(null);
    }
    length--;
    return temp.getData();
  }

  public int removeFromTail() {
    if (isEmpty()) {
      return Integer.MIN_VALUE;
    }
    CLLNode finger = tail;
    while (finger.getNext() != tail) {
      finger = finger.getNext();
    }
    CLLNode temp = tail;
    if (finger == tail) {
      tail = null;
    } else {
      finger.setNext(tail.getNext());
      tail = finger;
    }
    length--;
    return temp.getData();
  }

  public boolean contains(int data) {
    if (tail == null)
      return false;
    CLLNode finger;
    finger = tail.getNext();
    while (finger != tail && (!(finger.getData() == data))) {
      finger = finger.getNext();
    }
    return finger.getData() == data;
  }

  public int remove(int data) {
    if (tail == null)
      return Integer.MIN_VALUE;
    CLLNode finger = tail.getNext();
    CLLNode previous = tail;
    int compares;
    for (compares = 0; compares < length && (!(finger.getData() == data)); compares++) {
      previous = finger;
      finger = finger.getNext();
    }
    if (finger.getData() == data) {
      if (tail == tail.getNext()) {
        tail = null;
      } else {
        if (finger == tail)
          tail = previous;
        previous.setNext(previous.getNext().getNext());
      }
      finger.setNext(null);
      length--;
      return finger.getData();
    } else
      return Integer.MIN_VALUE;
  }

  public int size() {
    return length;
  }

  public int length() {
    return length;
  }

  public boolean isEmpty() {
    return tail == null;
  }

  public void clear() {
    length = 0;
    tail = null;
  }

  public String toString() {
    String result = "[";
    if (tail == null) {
      return result + "]";
    }
    result = result + tail.getData();
    CLLNode temp = tail.getNext();
    while (temp != tail) {
      result = result + "," + temp.getData();
      temp = temp.getNext();
    }
    return result + "]";
  }
}
