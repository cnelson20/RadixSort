public class Radix {
	public static int nth(int n, int col) {
		return (int)(n % Math.pow(10,col+1)) / (int)(Math.pow(10,col));
	}
	public static int length(int n) {
		return (int)(Math.log10(n)) + 1;
	}
	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			original.extend(buckets[i]);
		}
	}
	public static void sort(SortableLinkedList list) {
		SortableLinkedList[] buckets = new SortableLinkedList[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new SortableLinkedList();
		}
		int maxLength = 1;
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < buckets.length; j++) {
				if (i == 0) {
					maxLength = Math.max(maxLength,list.get(i));
				}
				buckets[nth(list.get(i),i)].add(list.get(i));
			}
			list = new SortableLinkedList();
			merge(list,buckets);
		}
	}
}
