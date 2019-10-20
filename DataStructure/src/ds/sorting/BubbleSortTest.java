package ds.sorting;

public class BubbleSortTest {

	public static void main(String[] args) {
		
		System.out.println("Hell");
		int[] array = {2, 4, 5, 3, 7, 8, 9, 6,1};
		
		
		for(int k = 0; k < array.length; k++){
			System.out.print(array[k] + " ");
		}
		System.out.println();
		/*
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length - 1 -i; j++){
				if(array[j] > array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println(array[array.length - 1]);
		for(int k = 0; k < array.length; k++){
			System.out.print(array[k] + " ");
		}
		*/
		bubblelower(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		
	}
	
	private static int[] bubbleupper(int[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length - 1 -i; j++){
				if(array[j] > array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			
			
		}
		
		return array;
	}
	
	private static int[] bubblelower(int[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length - 1 -i; j++){
				if(array[j] < array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			
			for(int k = 0; k < array.length; k++){
				System.out.print(array[k] + " ");
			}
			System.out.println();
		}
		
		return array;
	}


}
