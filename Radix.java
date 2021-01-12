public class Radix {
	public static int nth(int n, int col) {
		return (int)(n % Math.pow(10,col+1)) / (int)(Math.pow(10,col));
	}
	public static int length(int n) {
		return (int)(Math.log10(n));
	}
	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			original.extend(buckets[i]);
		}
	}
	public static void sort(SortableLinkedList list) {
		
	}
}
