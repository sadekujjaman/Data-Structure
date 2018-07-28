package ds.sorting;

import java.util.Scanner;

public class QuickSortTest {
 
	private static Scanner sc = new Scanner(System.in);
	private static int size = sc.nextInt();
	private static int[] array = new int[size];//{28, 60, 72, 56, 18, 69, 21, 95, 31, 17, 23, 90, 70, 44, 52, 24};
	public static void main(String[] args) {
		
		
		//size = sc.nextInt();
		for(int i = 0; i < array.length; i++){
			array[i] = sc.nextInt();
		}
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		quickSort(0, array.length - 1);
		
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private static void quickSort(int left, int right){
		
		if((right - left) <= 0)
			return;
		int pivot = array[right];
		int portion = portionIt(left, right, pivot);
		
		quickSort(left, portion - 1);
		quickSort(portion + 1, right);
	  
	}
	// 12 24 56 13
	private static int portionIt(int left, int right, int pivot){
		int leftPtr = left - 1;
		int rightPtr = right;
		
		while(true){
		while(array[++leftPtr] < pivot ){}
		
		while(rightPtr > 0 && array[--rightPtr] > pivot){}
		
		if(leftPtr >= rightPtr)
			break;
		else{
			swap(leftPtr, rightPtr);
		}
		}
		
		swap(leftPtr, right);
		return leftPtr;
	}
	
	private static void swap(int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	private static void printArray(int arr[], int minpos, int maxpos){
		for(int i = minpos; i<=maxpos; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
