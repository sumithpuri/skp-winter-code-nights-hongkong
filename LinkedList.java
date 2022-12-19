// tested by code@sumithpuri.xyz on [19/Dec/2022]
// please star/like, follow & fork from my github
// p refer https://onecompiler.com/java/3ysbcbtzj 

/**
 * Feel free to distribute, modify or include
 */

/**
 * @author sumithpuri
 * @label jdk7certify
 * 
 * An Implementation of the LinkedList Reversal. Use of Object-Orientation.
 *
 */
public class LinkedList {
	
	private int value;
	private LinkedList next;
	
	public LinkedList(int i) {
		this.value=i;
	}
	

	/**
	 * @return the next
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * @return the next
	 */
	public LinkedList getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(LinkedList next) {
		this.next = next;
	}
	
	// iterative reversal of linked list
	public LinkedList iReverse() {
		
		// three pointer or variable method
		LinkedList curr, prev, next, head=null;
		
		// set tail
		prev=this;
		curr=prev.getNext();
		prev.setNext(null);
		while(curr != null) {
			next=curr.getNext();
			curr.setNext(prev);
			prev=curr;
			curr=next;
			
		}
		
		// debug statement
		// System.out.println(prev.getValue());
		head=prev;
		return head;
		
	}
	
	// recursive reversal of linked list
	public LinkedList rReverse(LinkedList head) {
		
		LinkedList newHead=head.getNext();
		if(head==null || newHead==null) return head;
		head.setNext(null);
		LinkedList val=rReverse(newHead);
		newHead.setNext(head);
		return val;
	}

	
	
	
	// converts array to linked list - return head
	private static LinkedList convertArrayToLinkedList(Integer arrToList[]){
		
		int i=0;
		LinkedList head=new LinkedList(arrToList[0]), curr=null, next=null;
		curr=head;
		for(int x=1;x<(arrToList.length);x++) {
			Integer num=arrToList[x];
			next=new LinkedList(num);
			curr.setNext(next);
			curr=next;
		}
		curr.setNext(null);
		return head;
	}
	
	
	public static void main(String[] args) {
		
		// Example 01:  74,37,11,45,61
		// Example 02:  45,38,12,62,42
		Integer arrToList[] = new Integer[] { 74,37,11,45,61 };
		
		// linked list as object - oop call
		LinkedList head=convertArrayToLinkedList(arrToList);
		System.out.println("==============================================================");
		System.out.print("Linked List Contents: [");
		head.printContents();
		head=head.iReverse();
		System.out.print("Linked List Contents: [Iterative Reversal]: [");
		head.printContents();
		head=head.rReverse(head);
		System.out.print("Linked List Contents: [Recursive Reversal]: [");
		head.printContents();
		System.out.println("==============================================================");
	}
	
	
	
	private void printContents() {
		
		LinkedList curr=this;
		while(curr != null) {
			System.out.print(" " + curr.getValue());
			curr=curr.getNext();
		}
		System.out.println(" ]");
	}
}
