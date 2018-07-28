package ds.sorting;

public class SelectionSortTest {

	public static void main(String[] args) {
		
		System.out.println("Hell");
		int[] array = {2, 4, 5, 3, 7, 8, 9, 6, 1};
		
		
		for(int k = 0; k < array.length; k++){
			System.out.print(array[k] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < array.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < array.length ; j++){
				if(array[j]<array[min]){
					min = j;
				}
			}
			
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		for(int k = 0; k < array.length; k++){
			System.out.print(array[k] + " ");
		}
	}

}
