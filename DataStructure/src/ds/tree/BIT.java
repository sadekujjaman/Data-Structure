package ds.tree;

import java.util.Scanner;

public class BIT {

	private static final int SIZE = 100;
	private static int[] arr = new int[SIZE + 1];
	private static int[] BIT = new int[SIZE + 1];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++){
			arr[i] = sc.nextInt();
			update(n, i, arr[i]);
		}
		for(int i = 1; i <= n; i++){
			System.out.print(BIT[i] + " ");
		}
		
		System.out.println();
		System.out.println("Sum of first 10 element: " + query(10));
		
	    System.out.println("Sum of all elements of range[2, 7]: " + (query(7) - query(1)));
		sc.close();
	}


	private static int query(int index) {
		int sum = 0;
		for(; index > 0; index -= (index & (-index))){
			sum += BIT[index];
		}
		return sum;
	}


	private static void update(int size, int index, int val) {
		for(; index <= size; index+=(index & (-index))){
			BIT[index]+=val;
		}
	}

}
