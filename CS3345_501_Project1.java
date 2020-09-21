import java.util.*;
import java.io.*;


public class CS3345_501_Project1 {

	public static long comparisons = 0;
	public static long movements = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		String listType, sortType, winningAlgo;
		int listSize;
		long startTime, endTime, elapsedTime, comparWin, moveWin;
		int[] list;
		comparWin = Long.MAX_VALUE;
		moveWin = 0;
		winningAlgo = "nothing";
		//Get list type and size
		System.out.println("Select a list type: ");
		
		listType = userInput.readLine();
		
		System.out.println("Select list size: ");
		
		listSize = Integer.parseInt(userInput.readLine());
		
		list = new int[listSize];
		Integer[] listInteger = new Integer[listSize]; 
		switch(listType) {
		
		case "random":
		//create the array (just random for now)

			for (int i = 0; i < list.length; i++)
			{
				list[i] = (int) (Math.random() * listSize);
			}
			//converts int array to Integer array for heap sort
			for (int i =0; i < listInteger.length; i++)
			{
				listInteger[i] = list[i];
			}
			break;
		case "inorder":
			//create in order array
			for (int i=0; i < list.length; i++)
			{
				list[i] = i;
			}
			for (int i =0; i < listInteger.length; i++)
			{
				listInteger[i] = list[i];
			}
			break;
		case "reverseorder":
			int k =0;
			for (int i= list.length-1; i >=0; i--, k++)
			{
				list [k] = i;
			}
			for (int i =0; i < listInteger.length; i++)
			{
				listInteger[i] = list[i];
			}
			break;
		case "almostorder":
			int inorderLength = (int) (listSize*.8);
			int i=0;
			while (i < inorderLength)
			{
				list[i] = i;
				i++;
			}
			for (int j=inorderLength; j < listSize; j++)
			{
				list[j] = (int) (Math.random() * listSize);
			}
			for (int l =0; l < listInteger.length; l++)
			{
				listInteger[l] = list[l];
			}
			break;
		default:
			break;
		}
		//copy the original list into a list to actually sort
		int [] list2 = new int[listSize];
		for (int i=0; i<list.length; i++)
		{
			list2[i] = list[i];
		}
		
		//output test for listtype
		/**for (int i=0;i < list.length; i++)//don't forget how we switched the test output when testing quicksort
		{
				System.out.println(list2[i]);
		}*/
		
		
		comparisons = 0;
		int x = 1;
		//try {
		while (x != 0) {
			System.out.println("Select your sort type: ");
			
			sortType = userInput.readLine();
			
			switch (sortType) {
			case "insertion":
				startTime = System.nanoTime();
				InsertionSort.insertionSort(list2);
				endTime = System.nanoTime();
				elapsedTime = endTime-startTime;
				break;
			case "merge":
				startTime = System.nanoTime();
				MergeSort.mergeSort(list2);
				endTime = System.nanoTime();
				elapsedTime = endTime-startTime;
				break;
			case "selection":
				startTime = System.nanoTime();
				SelectionSort.selectionSort(list2);
				endTime = System.nanoTime();
				elapsedTime = endTime-startTime;
				break;
			case "quick":
				startTime = System.nanoTime();
				QuickSort.quickSort(list2);
				endTime = System.nanoTime();
				elapsedTime = endTime-startTime;
				break;
			case "heap":
				startTime = System.nanoTime();
				Heap.heapSort(listInteger);
				endTime = System.nanoTime();
				elapsedTime = endTime-startTime;
				break;
			case "radix":
				startTime = System.nanoTime();
				RadixSort.radixSort(list2, listSize);
				endTime = System.nanoTime();
				elapsedTime = endTime-startTime;
				break;
			
			default:
				elapsedTime = 0;
				break;
			
			
			}
			System.out.println(sortType);
			if (sortType.equals("heap")) {
				for (int i=0;i < listInteger.length; i++)//don't forget how we switched the test output when testing quicksort
				{
						System.out.println(listInteger[i]);
				}
				
			}
			else {
				for (int i=0;i < list.length; i++)//don't forget how we switched the test output when testing quicksort
				{
						System.out.println(list2[i]);
				}
			
			}
			//
			for (int i=0; i<list.length; i++)
			{
				list2[i] = list[i];
			}
			for (int i =0; i < listInteger.length; i++)
			{
				listInteger[i] = list[i];
			}
			
			//print the probes
			System.out.println("The amount of comparisons is: " + comparisons);
			System.out.println("The amount of movements is: " + movements);
			System.out.println("The amount of time spent in nano seconds is: " + elapsedTime);
			System.out.println("The amount of time spent in milliseconds: " + elapsedTime/1000000);
			
			if ((comparisons + movements) < (comparWin + moveWin))
			{
				comparWin = comparisons;
				moveWin = movements;
				winningAlgo = sortType;
			}
			
			System.out.println("The current winning algorithm is: " + winningAlgo);
			
			comparisons = 0;
			movements = 0;
			
			System.out.println("Exit by pressing 0, press anything else to continue");
			x = Integer.parseInt(userInput.readLine());
		}
		//}
		//catch (Throwable ex) {
			
		//}
		
		//System.out.print(Arrays.toString(list)); This does not work. There seems to be a hardcap to the elements that can be printed at approximately 5531 elements.

	}

}






























