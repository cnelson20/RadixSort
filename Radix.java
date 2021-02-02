public class Radix {
  public static int nth(int n, int col) {
    n = Math.abs(n);
    if (col < 0) {
      throw new IndexOutOfBoundsException();
    }
    return (int)(n % Math.pow(10,col+1)) / (int)Math.pow(10,col);
  }
  public static int length(int n) {
    return (int)Math.log10(n) + 1;
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void sort(MyLinkedList list) {
    MyLinkedList[] buckets = new MyLinkedList[10];
    int maxLength = 0;
    for (int i = 0; i < list.size(); i++) {
      maxLength = Math.max(maxLength,length(list.get(i)));
    }
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList();
    }
    for (int i = 0; i < maxLength; i++) {
      for (int j = 0; j < list.size(); j++) {
        buckets[nth(list.get(j),i)].add(list.get(j));
      }
      list.clear();
      merge(list,buckets);
    }
  }

}
