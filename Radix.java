public class Radix {
	public static int nth(int n, int col) {
		Math.abs(nthNoAbs(n,col));
	}
	private static int nthNoAbs(int n, int col) {
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
	public static void radixSortSimple(SortableLinkedList list) {
		SortableLinkedList dummy = new SortableLinkedList();
		SortableLinkedList[] buckets = new SortableLinkedList[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new SortableLinkedList();
		}
		int mLength = 1;
		int m = 0;
		for (int i = 0; i <= mLength; i++) {
			//i is the digit of the number we sorting
			//System.out.println();
			while(list.size() > 0) {
				//j is the element of the list
				int element = list.remove(0);
				if (i == 0) {
					m = Math.max(m,Math.abs(element));
				}
				//System.out.println(element);
				buckets[nthNoAbs(element,i)].add(element);
			}
			merge(list,buckets);
			if (i == 0) {
				mLength = length(m);
			}
	}
}
	public static void radixSort(SortableLinkedList list) {
		SortableLinkedList dummy = new SortableLinkedList();
		SortableLinkedList[] buckets = new SortableLinkedList[19];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new SortableLinkedList();
		}
		int mLength = 2;
		int m = 0;
		for (int i = 0; i <= mLength; i++) {
			//i is the digit of the number we sorting
			//System.out.println();
			while(list.size() > 0) {
				//j is the element of the list
				int element = list.remove(0);
				if (i == 0) {
					m = Math.max(m,Math.abs(element));
				}
				//System.out.println(element);
				buckets[nthNoAbs(element,i)+9].add(element);
			}
			merge(list,buckets);
			if (i == 0) {
				mLength = length(m);
			}
		}

	}
}
