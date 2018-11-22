package ds.sorting;

public class OddEvenMergeSort {
	
	public static void main(String[] args) {
		
		
		OddEvenMergeSort oddEven = new OddEvenMergeSort();
		int arr[] = {25, 21, 8, 5, 2, 13, 11, 16, 23, 31, 9, 4, 18, 12, 27, 34};
		oddEven.sort(arr);
		//int arr1[] = oddEven.a;
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		} 
		
	}

	private int[] a;

	public void sort(int[] a) {
		this.a = a;
		oddEvenMergeSort(0, a.length);
	}

	/**
	 * sorts a piece of length n of the array starting at position lo
	 */
	private void oddEvenMergeSort(int lo, int n) {
		if (n > 1) {
			int m = n / 2;
			oddEvenMergeSort(lo, m);
			oddEvenMergeSort(lo + m, m);
			oddEvenMerge(lo, n, 1);
		}
	}

	/**
	 * lo is the starting position and n is the length of the piece to be merged, r
	 * is the distance of the elements to be compared
	 */
	private void oddEvenMerge(int lo, int n, int r) {
		int m = r * 2;
		if (m < n) {
			oddEvenMerge(lo, n, m); // even subsequence
			oddEvenMerge(lo + r, n, m);// odd subsequence
			for (int i = lo + r; i + r < lo + n; i += m)
				compare(i, i + r);
		} else
			
			compare(lo, lo + r);
	}

	private void compare(int i, int j) {
		if (a[i] > a[j])
			exchange(i, j);
	}

	private void exchange(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}