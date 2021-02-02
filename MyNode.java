public class MyNode {
  private int data;
  private MyNode prev,next;

  public MyNode(int data, MyNode next) {
    this.data = data;
    this.next = next;
  }
  public MyNode(int value) {
    data = value;
    this.next = null;
    this.prev = null;
  }
  public MyNode(int data, MyNode prev, MyNode next) {
    this.data = data;
    this.prev = prev;
    this.next = next;
  }
  public int getValue(){
    return this.data;
  }
  public boolean setValue(int value){
    this.data = value;
    return true;
  }
  public MyNode getPrev(){
    return this.prev;
  }
  public MyNode getNext(){
    return this.next;
  }
  public boolean setNext(MyNode value) {
    this.next = value;
    return true;
  }
  public boolean setPrev(MyNode value) {
    this.prev = value;
    return true;
  }
}
