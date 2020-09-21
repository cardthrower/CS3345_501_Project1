
public class InsertionSort {
	public static void insertionSort(int[] list) {
		
		for (int i = 1; i < list.length; i++) {
			
			int currentElement = list[i];
			int k;
			int temp = i-1;
			for (k = i-1; k >=0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
				CS3345_501_Project1.comparisons++;
				CS3345_501_Project1.movements++;
			}
			if (k == temp)
			{
				CS3345_501_Project1.comparisons++;
			}
			list[k + 1] = currentElement;
		}
	}
}
