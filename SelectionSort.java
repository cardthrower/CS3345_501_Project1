
public class SelectionSort {
	//modified selectionSort to int list to standardize across program
	public static void selectionSort(int[] list) {
		for (int i=0; i<list.length - 1; i++) {
			//Find the minimum in the list
			int currentMin = list[i];
			int currentMinIndex = i;
			for (int j=i+1; j<list.length; j++) {

				if(currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;

				}
				CS3345_501_Project1.comparisons++;
			}
			
			//swap list[i] with list[currentMinIndex] if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
				CS3345_501_Project1.movements++;
				
			}
		}
	}
}
