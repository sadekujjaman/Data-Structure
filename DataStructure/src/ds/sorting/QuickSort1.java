package ds.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		int pivot = arr[0];
		for(int i = 1; i < arr.length; i++){
			int num = arr[i];
			if(num < pivot){
				leftList.add(num);
			}
			else if(num > pivot){
				rightList.add(num);
			}
		}
		for(int i = 0; i < leftList.size(); i++){
			System.out.print(leftList.get(i) + " ");
		}
		System.out.print(pivot + " ");
		for(int i = 0; i < rightList.size(); i++){
			System.out.print(rightList.get(i) + " ");
		}
		sc.close();
	}

}
