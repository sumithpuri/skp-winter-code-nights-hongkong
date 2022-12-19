// tested by code@sumithpuri.xyz on [19/Dec/2022]
// please star/like, follow & fork from my github
// p refer https://onecompiler.com/java/3ysb9zf9b

/**
 * Feel free to distribute, modify or include
 */

/**
 * @author sumithpuri
 * @label jdk7certify
 * 
 * An Implementation of the MergeSort Algorithm. 
 *
 */
public class MergeSort {

	
	// merge sort - signature
	public void sort(Integer[] unsortedArray) {
	
		/*
		 * if(high-low <= 1) return; 
		 * less memory version - needs debugging
			int middle=(low+high)/2;
			printArray (low, high, middle, unsortedArray);
		
			sort(unsortedArray,low,middle);
			sort(unsortedArray,middle,high);
			merge(unsortedArray,low,middle,high);
		*/
		
		// use of arrays - more on memory
		int gLen=unsortedArray.length;
		if(gLen <= 1) return;
		
		int middle=(unsortedArray.length)/2;
		Integer[] sortedOne=new Integer[middle];
		Integer[] sortedTwo=new Integer[gLen-middle];
		System.arraycopy(unsortedArray, 0, sortedOne, 0, middle);
		System.arraycopy(unsortedArray, sortedOne.length, sortedTwo, 0, sortedTwo.length);
		
		// debug message
		// printArray(sortedOne.length, sortedTwo.length, middle, unsortedArray);
		
		sort(sortedOne);
		sort(sortedTwo);
		merge(sortedOne,sortedTwo,unsortedArray);
	}
	
	
	// merge sort - specific
	public void merge(Integer[] sortedOne, Integer[] sortedTwo, Integer[] unsortedArray) {
		
		int a=0,b=0;
		int i=sortedOne.length, j=sortedTwo.length, k=0;
		
		// now do a comparison for specific indices - important
		while(a<i & b<j) {
			if(sortedOne[a] > sortedTwo[b]) {
				unsortedArray[k++]=sortedTwo[b++];
			} else { 
				unsortedArray[k++]=sortedOne[a++];		
			}
		}	
		
		int firstPos=sortedOne.length-a, secondPos=k+firstPos;
		
		System.arraycopy(sortedOne, a, unsortedArray, k, firstPos);
		System.arraycopy(sortedTwo, b, unsortedArray, secondPos, sortedTwo.length-b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Example 01:  {74,37,11,45,61,23,56,83,99,10};
		// Example 02:  {45,38,12,62,42,34,8,24,76,48};		
		Integer[] unsortedArray = new Integer[] {45,38,12,62,42,34,8,24,76,48};
		System.out.print("[The Given Array]: \n");
		for(int x: unsortedArray) System.out.print(x + " ");
		
		System.out.println();
		// instantiate object - embed in same way for your use
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(unsortedArray);
		System.out.println();
		System.out.print("[The Sorted Array] [Merge Sort]: \n");
		for(int x: unsortedArray) System.out.print(x + " ");
	}  
	
	// console debug
	public void printArray (int l, int h, int p, Integer[] arrayStore) {
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Debug: The Low Element Position is " + l);
		System.out.println("Debug: The High Element Position is " + h);
		System.out.println("Debug: The Middle Element Position is " + p);
		System.out.println("Debug: The Middle Element is " + arrayStore[p]);
		System.out.print("The Array Contents: ");
		for(int x: arrayStore) {
			System.out.print(x + " ");
		}
		System.out.println("\n---------------------------------------------------------");
	}

}
