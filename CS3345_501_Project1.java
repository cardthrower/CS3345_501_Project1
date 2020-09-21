import java.util.*;
import java.io.*;


public class CS3345_501_Project1 {

	public static long comparisons = 0;
	public static long movements = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		String listType, sortType, winningAlgo;
		int listSize;
		int exitProgram = 1;
		long startTime, endTime, elapsedTime, comparWin, moveWin;
		int[] list;
		ArrayList<String> algosUsed = new ArrayList<String>();
		comparWin = Long.MAX_VALUE;
		moveWin = 0;
		winningAlgo = "nothing";
		System.out.println("Welcome to the Sorting Algorithm Analysis Application!");
		while (exitProgram != 0) {
		
			//Get list type and size
			System.out.println ("List types are: random, inorder, reverseorder, almostorder.");
			System.out.println("Select a list type: ");
			
			listType = userInput.readLine();
			
			if (!(listType.equals("random")) && !(listType.equals("inorder")) && !(listType.equals("reverseorder")) && !(listType.equals("almostorder")) )
			{
				System.out.println("Please enter a valid list type");
				continue;
			}
			try {
				System.out.println("Enter list size: ");
			
				listSize = Integer.parseInt(userInput.readLine());
			}
			catch (Exception IOException)
			{
				System.out.print("Please enter a valid list size.\n");
				continue;
			}
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
				//create reverseorder array
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
				//create almostorder array
				int inorderLength = (int) (listSize*.8);
				int randLength = (listSize - inorderLength)/2;
				int i=0;
				while (i < randLength)
				{
					list[i] = (int) (Math.random() * listSize);
					i++;
				}
				for (int j=randLength; j < (inorderLength+randLength); j++)
				{
					list[j] = j;
					
				}
				for (int l = (inorderLength+randLength); l < listSize; l++)
				{
					list[l] = (int) (Math.random() * listSize);
				}
				
				for (int q =0; q < listInteger.length; q++)
				{
					listInteger[q] = list[q];
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
			
			/**output test for listtype
			for (int i=0;i < list.length; i++)//don't forget how we switched the test output when testing quicksort
			{
					System.out.println(list2[i]);
			}*/
			
			
			comparisons = 0;
			int x = 1;
	
			while (x != 0) {
				System.out.println("Sort types are: insertion, merge, heap, selection, quick, and radix");
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
					System.out.println("Please enter a sort.");
					continue;
				
				
				}
				/**System.out.println(sortType);
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
				
				}*/
				//Reset the lists for the next sort
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
				
				if ((comparisons + movements) < (comparWin + moveWin) && !(sortType.equals("")))
				{
					comparWin = comparisons;
					moveWin = movements;
					winningAlgo = sortType;
				}
				
				System.out.println("The current winning algorithm is: " + winningAlgo);
				comparisons = 0;
				movements = 0;
				if (algoUsedAlready(algosUsed, sortType) == 0)
				{
					algosUsed.add(sortType);
				}
				System.out.println("The algorithms already used are: " + algosUsed.toString());
				System.out.println("Exit to list creation by pressing 0, enter anything else to select another sort.");
				try {
					x = Integer.parseInt(userInput.readLine());
				}
				catch(Exception IOException)
				{
					continue;
				}
			}
			algosUsed.removeAll(algosUsed);
			winningAlgo = "nothing";
			System.out.println("Exit the program by entering 0, enter anything else to enter list creation.");
			try {
				exitProgram = Integer.parseInt(userInput.readLine()); 
			}
			catch(Exception IOException)
			{
				continue;
			}
				//System.out.print(Arrays.toString(list)); This does not work. There seems to be a hardcap to the elements that can be printed at approximately 5531 elements.
	
		}
	}
	public static int algoUsedAlready(ArrayList<String> arr, String algo)
	{
		int found = 0;
		for (int i=0; i<arr.size(); i++)
		{
			if (arr.get(i).equals(algo)) {
				found = 1;
			}
		}
		
		
		
		return found;
	}

}































