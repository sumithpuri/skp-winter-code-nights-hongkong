// tested by code@sumithpuri.xyz on [19/Dec/2022]
// please star/like, follow & fork from my github
// p refer https://onecompiler.com/java/3ysba7ct5

/**
 * Feel free to distribute, modify or include
 */

/**
 * @author sumithpuri
 * @label jdk7certify
 * 
 * An Implementation of the QuickSort Algorithm (Worst - Case Behavior). Use the 
 * Sedgewick Recommendation for Better Performance.
 *
 */
import java.util.List;
import java.util.ArrayList;
 
public class QuickSort {

	
	// quick sort - signature
	public void sort(Integer[] unsortedArray, int low, int high) {
		
		// first time choose highest as the pivot element
		int p=partition(unsortedArray, low, high);
		// debug statement
		// printArray(low, high, p, unsortedArray);
		if(low < p-1) sort(unsortedArray, low, p-1);
		if(high > p) sort(unsortedArray, p, high);
	}
	
	// quick sort only partition
	public int partition(Integer[] unsortedArray, int low, int high) {		
		
		// can provide any form of determination of pivot here
		int pivot=unsortedArray[low];
		// System.out.println("DEBUG--------------------------------START");
		// for(int x: unsortedArray) System.out.print(x + " ");
		// System.out.println("");
		// System.out.println("DEBUG--------------------------------"+pivot+","+low+","+high);
		while((low <= high)) {
			while(unsortedArray[low] < pivot) low++;
			while(unsortedArray[high] > pivot) high--;	
			if(low <= high) {				
				int temp=unsortedArray[low];
				unsortedArray[low]=unsortedArray[high];
				unsortedArray[high]=temp;
				low++;high--;
			}
		}		
		
		return low;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Example 01: {74,37,11,45,61,23,56,83,99,10};
		// Example 02: {45,38,12,62,42,34,8,24,76,48};
		// Example 03: {-1,-5,10,-4,0,22,-22,-15,99,77};
		// Example 04: {0,1,2,3,4,5,6,-1,-2,-3};
		// Example 05: {-21,-20,-19,-18,0,1,1,1,4,4};
		
		List<Object> arrayList = new ArrayList<Object>();
		Integer[] unsortedArray = new Integer[] {74,37,11,45,61,23,56,83,99,10};
		arrayList.add(unsortedArray);
		unsortedArray = new Integer[] {45,38,12,62,42,34,8,24,76,48};
		arrayList.add(unsortedArray);
		unsortedArray = new Integer[] {-1,-5,10,-4,0,22,-22,-15,99,77};
		arrayList.add(unsortedArray);
		unsortedArray = new Integer[] {0,1,2,3,4,5,6,-1,-2,-3};
		arrayList.add(unsortedArray);
		unsortedArray = new Integer[] {-20,-21,-19,-18,0,1,1,-1,4,-4};
		arrayList.add(unsortedArray);
		
		for(Object al: arrayList) {
			System.out.println();
			unsortedArray = (Integer[]) (al);
			System.out.print("[The Given Array]: \n");
			for(int x: unsortedArray) System.out.print(x + " ");
			
			System.out.println();
			// instantiate object - embed in same way for your use
			QuickSort quickSort = new QuickSort();
			quickSort.sort(unsortedArray, 0, unsortedArray.length-1);
			System.out.println();
			System.out.print("[The Sorted Array] [Quick Sort]: \n");
			for(int x: unsortedArray) System.out.print(x + " ");
			System.out.println();
		}
	}  
	
	// console debug
	public void printArray (int l, int h, int p, Integer[] arrayStore) {
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Debug: The Low Element Position is " + l);
		System.out.println("Debug: The High Element Position is " + h);
		System.out.println("Debug: The Pivot Element Position is " + p);
		System.out.println("Debug: The Pivot Quick Element is " + arrayStore[p]);
		System.out.print("The Array Contents: ");
		for(int x: arrayStore) {
			System.out.print(x + " ");
		}
		System.out.println("\n---------------------------------------------------------");
	}

}
