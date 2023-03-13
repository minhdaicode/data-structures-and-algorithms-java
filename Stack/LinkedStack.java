package Stack;

import java.util.EmptyStackException;

import LinkedList.ListNode;

public class LinkedStack<T> {
  private int length;
  private ListNode top;

  public LinkedStack() {
    length = 0;
    top = null;
  }

  public void push(int data) {
    ListNode temp = new ListNode(data);
    temp.setNext(top);
    top = temp;
    length++;
  }

  public int pop() throws EmptyStackException {
    if (isEmpty())
      throw new EmptyStackException();
    int result = top.getData();
    top = top.getNext();
    length--;
    return result;
  }

  public int peek() throws EmptyStackException {
    if (isEmpty())
      throw new EmptyStackException();

    return top.getData();
  }

  public boolean isEmpty() {
    return (length == 0);
  }

  public int size() {
    return length;
  }

  public String toString() {
    String result = "";
    ListNode current = top;
    while (current != null) {
      result = result + current.toString() + "\n";
      current = current.getNext();
    }

    return result;
  }
}
