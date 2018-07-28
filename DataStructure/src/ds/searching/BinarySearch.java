package ds.searching;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < arr.length; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("end");
		System.out.println(binarySearch(arr, 0, arr.length - 1,55));
		sc.close();
	}

	private static boolean binarySearch(int[] arr, int min, int max, int search) {
		
		while(min <= max){
			
	    int middle = (min + max) / 2;
		int num = arr[middle];
		
			if(search < num)
				max = middle - 1;
			else if(search > num)
				min = middle + 1;
			else if(search == num){
				return true;
			}
			
		}
		
		return false;
	}

}
