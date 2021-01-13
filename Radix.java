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
	private static int maxLength(SortableLinkedList list) {
		int m = 1;
		for (int i = 0; i < list.size(); i++) {
			m = Math.max(m,length(list.get(i)));
		}
		return m;
	}
	public static void radixSortSimple(SortableLinkedList list) {
		SortableLinkedList dummy = new SortableLinkedList();
		SortableLinkedList[] buckets = new SortableLinkedList[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new SortableLinkedList();
		}
		int mLength = maxLength(list);
		for (int i = 0; i <= mLength; i++) {
			//i is the digit of the number we sorting
			//System.out.println();
			for (int j = 0; j < list.size(); j++) {
				//j is the element of the list
				int element = list.get(j);
				//System.out.println(element);
				buckets[nth(element,i)].add(element);
			}
			dummy.extend(list);
			merge(list,buckets);
		}
	}
	public static void radixSort(SortableLinkedList list) {
		SortableLinkedList dummy = new SortableLinkedList();
		SortableLinkedList[] buckets = new SortableLinkedList[19];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new SortableLinkedList();
		}
		int mLength = maxLength(list);
		for (int i = 0; i <= mLength; i++) {
			//i is the digit of the number we sorting
			//System.out.println();
			for (int j = 0; j < list.size(); j++) {
				//j is the element of the list
				int element = list.get(j);
				//System.out.println(element);
				if (element > 0) {
				buckets[nth(element,i)+9].add(element);
				} else {
				buckets[9 - nth(element,i)].add(element);
				}
			}
			dummy.extend(list);
			merge(list,buckets);
		}
	}
}
