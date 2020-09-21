
public class QuickSort {
	//Quick Sort!
	public static void quickSort(int[]list) {
		quickSort(list, 0, list.length-1);
	}
	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
			 CS3345_501_Project1.comparisons++;
		}
	}
	public static int partition(int[] list, int first, int last) {
		int pivot = list[(first+last)/2]; //kept at first, per the class discussion
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			//search forward from left
			while (low <= high && list[low] <= pivot)
				low++;
			
			//search backward from right
			while (low <= high && list[high] > pivot)
				high--;
			
			//swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
				CS3345_501_Project1.comparisons++;
				CS3345_501_Project1.movements++;
			}
		}
		
		while(high > first && list[high] >= pivot)
			high--;
		
		//swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			CS3345_501_Project1.comparisons++;
			CS3345_501_Project1.movements++;
			return high;
			
			
		}
		else {
			CS3345_501_Project1.comparisons++;
			CS3345_501_Project1.movements++;
			return first;
		}
	}
}
