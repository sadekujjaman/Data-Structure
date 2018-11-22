package ds.sorting;

public class MergeSort {
	static int[] arr = { 25, 21, 8, 5, 2, 13, 11, 16, 23, 
			31, 9, 4, 18, 12, 27, 34 };
	static int[] arr2 = new int[arr.length];

	public static void main(String[] args) {

		mergeSort(0, arr.length - 1);

		for (int i = 0; i < arr2.length; i++) {

			System.out.print(arr2[i] + " ");
		}
	}

	private static void mergeSort(int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;

			mergeSort(low, mid);
			mergeSort(mid + 1, high);

			merge(low, mid, high);
		}

	}

	private static void merge(int low, int mid, int high) {
		int h = low;
		int i = low;
		int j = mid + 1;

		while (h <= mid && j <= high) {
			if (arr[h] <= arr[j]) {
				arr2[i] = arr[h];
				h++;
			} else {
				arr2[i] = arr[j];
				j++;
			}
			i++;
		}

		if (h > mid) {
			for (int k = j; k <= high; k++) {
				arr2[i] = arr[k];
				i++;
			}
		} else {
			for (int k = h; k <= mid; k++) {
				arr2[i] = arr[k];
				i++;
			}
		}

		for (int k = low; k <= high; k++) {
			arr[k] = arr2[k];
		}
	}
	
	
}
