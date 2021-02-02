public class Tester {
  public static void main (String[] args) {
    System.out.println(Radix.nth(123,2));
    System.out.println(Radix.nth(123,1));
    System.out.println(Radix.nth(123,0));
    System.out.println();
    System.out.println(Radix.length(123));

    MyLinkedList hold_randoms = new MyLinkedList();
    int length = args.length > 0 ? Integer.parseInt(args[0]) : 100;
    int maxRandom = 100;
    for (int i = 0; i < 100; i++) {
      hold_randoms.add((int)(Math.random()*maxRandom));
    }
    System.out.println("\n" + hold_randoms.toString());

    MyLinkedList sorted = hold_randoms;
    Radix.sort(sorted);
    System.out.println(sorted.toString());
  }
}
