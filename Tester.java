public class Tester {
  public static void main(String[] args) {
    System.out.println(Radix.nth(123,0));
    System.out.println(Radix.nth(123,1));
    System.out.println(Radix.nth(123,2));
    System.out.println(Radix.length(123));

    SortableLinkedList hold_randoms = new SortableLinkedList();
    int len = args.length > 0 ? Integer.parseInt(args[0]) : 100;
    for (int i = 0; i < len; i++) {
      hold_randoms.add((int)(Math.random()*2000 - 1000));
    }
    //System.out.println(Radix.maxLength(hold_randoms));

    System.out.println(hold_randoms);
    Radix.radixSort(hold_randoms);
    System.out.println(hold_randoms);
  }
}
