public class MyLinkedList {
  private int length;
  private MyNode head, tail;

  public MyLinkedList() {
    length = 0;
    head = null;
    tail = head;
  }

  public boolean add(int value) {
    MyNode v = new MyNode(value,tail,null);
    if (length == 0) {
      head = v;
      tail = head;
    } else {
      tail.setNext(v);
      tail = v;
    }
    length++;
    return true;
  }
  public void add(int index, int value) {
    if (length == 0) {
      add(value);
      length--;
    } else if (index < 0 || index > length) {
      throw new IndexOutOfBoundsException();
    } else if (index == 0) {
      head = new MyNode(value,null,head);
      head.getNext().setPrev(head);
    } else if (index == length) {
      add(value);
      length--;
    } else {
      MyNode pr = getNode(index - 1);
      MyNode nxt = getNode(index);
      MyNode newNode = new MyNode(value,pr,nxt);
      pr.setNext(newNode);
      if (nxt != null) {
        nxt.setPrev(newNode);
      }
    }
    length++;
  }
  public String toString() {
    MyNode current = head;
    String ret = "[";
    while (current != null) {
      if (current != head) {ret += ", ";}
      ret += current.getValue();
      current = current.getNext();
    }
    return ret + "]";
  }
  public String toStringReversed() {
    MyNode current = tail;
    String ret = "[";
    while (current != null) {
      if (current != tail) {ret += ", ";}
      ret += current.getValue();
      current = current.getPrev();
    }
    return ret + "]";
  }
  public int size() {
    return length;
  }
  public int set(int index, int str) {
    MyNode current = head;
    for (int i = 0; i < index; i++) {
      current = head.getNext();
    }
    int temp = current.getValue();
    current.setValue(str);
    return temp;
  }
  private MyNode getNode(int index) {
    MyNode current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }
  public void clear() {
    head = null;
    tail = null;
    length = 0;
  }
  public int get(int index) {
    if (index < 0 || index >= length) {
      throw new IndexOutOfBoundsException();
    }
    return getNode(index).getValue();
  }
  public int remove(int index) {
    MyNode removed = getNode(index+1);
    //System.out.println(removed.getValue());
    MyNode pr = removed.getPrev();
    //System.out.println(pr.getValue());
    MyNode nxt = removed.getNext();
    //System.out.println(nxt.getValue());
    pr.setNext(nxt);
    nxt.setPrev(pr);

    length--;
    return removed.getValue();
  }
  public void extend(MyLinkedList other) {
    if (length == 0) {
      this.head = other.head;
      this.tail = other.tail;
    } else {
      this.tail.setNext(other.head);
      if (other.length > 0) {
        other.head.setPrev(this.tail);
        this.tail = other.tail;
      }
    }
    this.length += other.length;
    other.clear();
  }

}
