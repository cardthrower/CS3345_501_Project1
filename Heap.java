
public class Heap<E extends Comparable<E>> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	
	/** Make a default heap */
	public Heap() {
	}
	
	
	/** Make a heap from an array */
	public Heap(E[] objects) {
		for (int i = 0; i <objects.length; i++)
			add(objects[i]);
	}
	
	
	/** Add a new object into the heap */
	public void add(E newObject) {
		list.add(newObject); //Append to the heap
		int currentIndex = list.size()-1; //index of last node
		
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1)/2;
			//Swap if the current object is greater than its parent
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex,  list.get(parentIndex));
				list.set(parentIndex, temp);
				CS3345_501_Project1.comparisons++;
				CS3345_501_Project1.movements++;
				
			}
			else {
				CS3345_501_Project1.comparisons++;
				break; // the tree is now a heap
			}
			
			currentIndex = parentIndex;
		}
	}
	
	/** Remove the root from the heap */
	public E remove() {
		if (list.size() == 0) return null;
		
		E removedObject = list.get(0);
		list.set(0,  list.get(list.size() -1));
		list.remove(list.size() -1);
		
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			//find max between 2 children
			if (leftChildIndex >= list.size()) break;
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
				CS3345_501_Project1.comparisons++;
			}
			//swap if the current node is less than maximum
			CS3345_501_Project1.comparisons++;
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
				CS3345_501_Project1.movements++;
			}
			else
				break; //tree is a heap
		}
		return removedObject;
	}
	public int getSize() {
		return list.size();
	}
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		//create a heap of integers
		Heap<E> heap = new Heap<>();
		
		//add elements to the heap
		for (int i=0; i<list.length; i++)
			heap.add(list[i]);
		
		//remove elements from the heap
		for (int i=list.length-1; i>=0; i--)
			list[i] = heap.remove();
		
	}
}
