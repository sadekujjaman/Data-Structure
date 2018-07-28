package ds.sorting;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		for(int i = 1; i < n; i++){
			
			for(int j = i; j > 0; j--){
				if(arr[j] < arr[j - 1]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
			for(int k = 0; k < n; k++){
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}
		
		sc.close();
		
	}

}
