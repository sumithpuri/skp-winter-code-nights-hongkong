// tested by code@sumithpuri.xyz on [19/Dec/2022]
// please star/like, follow & fork from my github
// p refer https://onecompiler.com/java/3ysbbd9sm

/**
 * Feel free to distribute, modify or include
 */

/**
 * @author sumithpuri
 * @label jdk7certify
 * 
 * An Implementation of the HeapSort Algorithm.
 *
 */
public class HeapSort {

	// let all have only one
	static int N=0;
	
	// heap sort - signature
	public void sort (Integer[] unsortedArray) {
		
		N=unsortedArray.length-1;
		heapify(unsortedArray);
		
		for(int i=N;i>=0;i--) {
			// debug statement
			// printArray(N, unsortedArray[0], unsortedArray);
			swap(unsortedArray,0,i);
			N=N-1;			
			maxHeap(unsortedArray,0);
		}
	}
	
	// heap sort - initial heapify
	public void heapify (Integer[] unsortedArray) {		
		
		for(int i=N/2; i>=0; i--) {
			maxHeap(unsortedArray,i);
		}
	}

	// heap sort - form max heap
	public void maxHeap (Integer[] unsortedArray, int p) {
		
		int max=p;
		
		// store binary tree as array
		int i=2*p;
		int j=(2*p)+1;
		
		if((i<=N) && (unsortedArray[i] > unsortedArray[p])) 
			max=i;
		if((j<=N) && (unsortedArray[j] > unsortedArray[max]))
			max=j;
		
		if(max!=p) {
			
			
			swap(unsortedArray,p,max);
			maxHeap(unsortedArray,max);
		}
	}
	
	// swap the two elements
	public void swap (Integer[] unsortedArray, int i, int j) {
		
		int temp=unsortedArray[i];
		unsortedArray[i]=unsortedArray[j];
		unsortedArray[j]=temp;
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
		HeapSort heapSort = new HeapSort();
		heapSort.sort(unsortedArray);
		System.out.println();
		System.out.print("[The Sorted Array] [Heap Sort]: \n");
		for(int x: unsortedArray) System.out.print(x + " ");
	}  
	
	// console debug
	public void printArray (int p, int e, Integer[] arrayStore) {
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Debug: The Current Position is " + p);
		System.out.println("Debug: The Current Element is " + e);
		System.out.print("The Array Contents: ");
		for(int x: arrayStore) {
			System.out.print(x + " ");
		}
		System.out.println("\n---------------------------------------------------------");
	}

}
