// tested by code@sumithpuri.xyz on [19/Dec/2022]
// please star/like, follow & fork from my github

/**
 * Feel free to distribute, modify or include
 */

/**
 * Individual Nodes to Use in Circular Linked List
 */

class Node {

	private int data;
	private Node next;

	/**
	 * @param data
	 */
	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}

/**
 * 
 * @author sumithpuri
 * @label jdk7certify
 * 
 *        An Implementation of the Circular LinkedList.
 *
 */
public class CircularLinkedList {

	// definition:in singly linked circular linked list, the last element points
	// back to the head or first element.technically you should not maintain the
	// last pointer, but size variable is allowed.
	Node first, last;
	int size = 0;

	public void insertAtBeg(int value) {

		System.out.println("CircularLinkedList: Inserting at Beginning: " + value);

		// node to insert
		Node iNode = new Node(value);

		Node tNode = first;
		if (tNode == null) {
			first = iNode;
			first.setNext(first);
		} else {

			while (tNode.getNext().getData() != first.getData())
				tNode = tNode.getNext();

			tNode.setNext(iNode);
			iNode.setNext(first);
			first = iNode;
		}
		size++;
		return;
	}

	public void insertAtEnd(int value) {

		System.out.println("CircularLinkedList: Inserting at End: " + value);

		// node to insert
		Node iNode = new Node(value);

		Node fNode = first, tNode = first, pNode = tNode;
		if (tNode == null) {
			first = iNode;
			System.out.println("Curr:: " + iNode.getData());
			first.setNext(first);
		} else {
			while (tNode.getNext().getData() != fNode.getData()) {
				tNode = tNode.getNext();
			}
			tNode.setNext(iNode);
			iNode.setNext(fNode);
		}
		size++;
		return;
	}

	public void insertAtPos(int value, int pos) {

		System.out.println("CircularLinkedList: Inserting at Position: " + pos + " Value: " + value);

		// node to insert, no modulo division
		// in some circular queues, we can implement modulo
		Node iNode = new Node(value);

		Node pNode = first, tNode = first;
		if (tNode == null) {
			first = iNode;
			first.setNext(first);

		} else {

			tNode = tNode.getNext();
			int i = 2;

			while (tNode != null) {
				if (i == pos)
					break;
				pNode = tNode;
				tNode = tNode.getNext();
				i++;
			}
			pNode.setNext(iNode);
			iNode.setNext(tNode);
		}

		size++;
		return;
	}

	// delete at specific position
	public void deleteAtPos(int pos) {

		System.out.println("CircularLinkedList: Deleting At Position: " + pos);

		Node pNode = first, tNode = first.getNext();

		if (tNode == null)
			return;

		int i = 2;
		while (tNode != null) {
			if (i == pos)
				break;
			pNode = tNode;
			tNode = tNode.getNext();
			i++;
		}
		pNode.setNext(tNode.getNext());

		size--;
	}

	public void print() {

		Node fNode = first, tNode = first.getNext();

		System.out.print("Circular Linked List: [");
		System.out.print(first.getData());
		while (first.getData() != tNode.getData()) {

			System.out.print("->");
			System.out.print(tNode.getData());
			tNode = tNode.getNext();
		}
		System.out.print("->");
		System.out.print(tNode.getData());
		System.out.println("]");
	}

	public static void main(String[] args) {

		CircularLinkedList circularLinkedList = new CircularLinkedList();
		// Example 01: 6>,4<,1>,-2,3>,0<,3+7,8>,9<,5<,4+11,-4
		// >:insert at beginning, <:insert at end, -:delete at position
		// +:insert at position

		// insert at beginning
		circularLinkedList.insertAtBeg(6);
		// insert at end
		circularLinkedList.insertAtEnd(4);
		// insert at beginning
		circularLinkedList.insertAtBeg(1);

		// print contents
		circularLinkedList.print();

		// delete at positioniNode
		circularLinkedList.deleteAtPos(2);// print contents
		circularLinkedList.print();

		// print contents
		circularLinkedList.print();

		// insert at beginning
		circularLinkedList.insertAtBeg(3);

		// print contents
		circularLinkedList.print();

		// insert at end
		circularLinkedList.insertAtEnd(0);

		// print contents
		circularLinkedList.print();

		// insert at position
		circularLinkedList.insertAtPos(7, 3);

		// print contents
		circularLinkedList.print();

		// insert at beginning
		circularLinkedList.insertAtBeg(8);
		// insert at end
		circularLinkedList.insertAtEnd(9);
		// insert at end
		circularLinkedList.insertAtEnd(5);
		// insert at position
		circularLinkedList.insertAtPos(11, 4);

		// print contents
		circularLinkedList.print();

		// delete at position
		circularLinkedList.deleteAtPos(4);

		// print contents
		circularLinkedList.print();

	}

}
