package ds.doublyLinked;;

public class DoublyLinkedListMain {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		// ---> 1 <-----
		// list.insertVal(5);
		// list.insertVal(8);
		// list.insertVal(10);

		// ----> 2 <-----
		// list.insertValBeforeTail(5);
		// list.insertValBeforeTail(10);
		// list.insertValBeforeTail(15);
		// list.insertValBeforeTail(20);

		// ----> 3 <------
		// list.insertAtHead(50);
		// list.insertAtHead(15);
		// list.insertAtHead(22);
		// list.insertAtHead(11);

		// -----> 4 <-------
		// list.insertAfterHead(33);
		// list.insertAfterHead(44);
		// list.insertAfterHead(55);
		// list.insertAfterHead(66);

		// -----> 5 <---------
		// list.insertAtPos(44, 1);
		// list.insertAtPos(23, 0);
		// list.insertAtPos(12, 0);
		// list.insertAtPos(14, 0);
		// list.insertAtPos(16, 3);
		// list.insertAtPos(32, 2);
		// list.insertAtPos(24, 2);

		// -----> 6 <---------
//		 list.insertAtRevPos(44, 1);
//		 list.insertAtRevPos(23, 0);
//		 list.insertAtRevPos(12, 0);
//		 list.insertAtRevPos(14, 0);
//		 list.insertAtRevPos(16, 3);
//		 list.insertAtRevPos(32, 2);
//		 list.insertAtRevPos(24, 7);

		// -----> 7 <------
		// System.out.println(list.findIndex(5));
		// list.insertVal(5);
		// list.insertVal(20);
		// list.insertVal(23);
		// System.out.println(list.findIndex(5));
		// System.out.println(list.findIndex(23));
		// System.out.println(list.findIndex(24));

		// -----> 8 <------
		// list.findValAtPos(0);
		// list.insertVal(5);
		// list.insertVal(20);
		// list.insertVal(23);
		// System.out.println(list.findValAtPos(0));
		// System.out.println(list.findValAtPos(2));
		// System.out.println(list.findValAtPos(3));

		// ------> 8 <------
		// list.insertVal(3);
		// list.insertVal(3);
		// list.insertVal(3);
		// list.traverse();
		// list.deleteAllOccur(3);
		// list.traverse();
		// list.insertVal(4);
		// list.insertVal(5);
		// list.insertVal(5);
		// list.insertVal(5);
		// list.traverse();
		// list.deleteAllOccur(5);
		// list.traverse();
		// list.insertVal(6);
		// list.insertVal(9);
		// list.insertVal(9);
		// list.insertVal(10);
		// list.traverse();
		// list.deleteAllOccur(9);
		// list.traverse();
		 list.insertVal(4);
		 list.insertVal(11);
		 list.insertVal(11);
		 list.insertVal(13);
		 list.insertVal(13);
		 list.traverse();
//		 list.deleteFirstOccurFromFirst(4);
		 list.deleteFirstOccurFromLast(13);
		 list.traverse();
		 list.deleteHead();
		 list.deleteTail();
		 list.traverse();
		 list.deleteAll();
		 System.out.println("Thanks!!");

		list.traverse();
		list.traverseBack();
	}

}

class Node {

	int data;
	Node next;
	Node previous;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	public void printNode() {
		System.out.print(this.data + " ");
	}

}

class LinkedList implements DoublyLinkedListInterface {

	Node firstNode;
	Node lastNode;

	int size;

	public LinkedList() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}

	@Override
	public void insertVal(int val) {
		Node newNode = new Node(val);
		// empty list
		if (firstNode == null) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			lastNode.next = newNode;
			newNode.previous = lastNode;
			lastNode = newNode;

		}
		size++;
	}

	@Override
	public void insertValBeforeTail(int val) {
		Node newNode = new Node(val);
		// empty list
		if (lastNode == null && firstNode == null) {
			firstNode = lastNode = newNode;
		}
		// one element
		else if (firstNode == lastNode && firstNode != null) {
			firstNode = newNode;
			firstNode.next = lastNode;
			lastNode.previous = firstNode;
		} else {

			Node currentNode = lastNode;
			Node previousNode = lastNode.previous;

			currentNode.previous = newNode;
			newNode.previous = previousNode;
			newNode.next = currentNode;
			previousNode.next = newNode;

		}
		size++;

	}

	@Override
	public void insertAtHead(int val) {
		Node newNode = new Node(val);
		// empty list
		if (firstNode == null && lastNode == null) {
			firstNode = lastNode = newNode;
		}
		// firstNode == lastNode && firstNode != null
		else {
			firstNode.previous = newNode;
			newNode.next = firstNode;
			firstNode = newNode;
		}
		// else{
		// firstNode.previous = newNode;
		//
		// newNode.next = firstNode;
		// firstNode = newNode;
		// }
		size++;

	}

	@Override
	public void insertAfterHead(int val) {
		Node newNode = new Node(val);
		// empty list
		if (firstNode == null && lastNode == null) {
			firstNode = lastNode = newNode;
		}
		// one element
		else if (firstNode == lastNode && lastNode != null) {
			newNode.previous = firstNode;
			firstNode.next = newNode;
			lastNode = newNode;
		} else {
			Node next = firstNode.next;

			newNode.previous = firstNode;
			newNode.next = next;
			firstNode.next = newNode;
			next.previous = newNode;
		}
		size++;
	}

	int getSize() {
		return size;
	}

	void printSize() {
		System.out.println("Size: " + size);
	}

	@Override
	public void insertAtPos(int val, int pos) {

		Node newNode = new Node(val);

		// if empty list then we insert the value as first element
		if (pos == 0 && firstNode == null) {
			firstNode = lastNode = newNode;
			size++;
			return;
		}
		// out of range
		if (pos != 0 && firstNode == null) {
			System.out.println("Index Out of Bounds");
			return;
		}

		if (pos == 0) {
			newNode.next = firstNode;
			firstNode.previous = newNode;
			firstNode = newNode;
			return;
		}
		int count = 0;

		Node currentNode = firstNode;
		Node previousNode = firstNode;

		while (currentNode != null) {

			if (count == pos) {

				newNode.next = currentNode;
				newNode.previous = previousNode;
				previousNode.next = newNode;
				currentNode.previous = newNode;
				// size++;
				return;
			}
			count++;
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		// else insert at last
		newNode.next = currentNode;
		newNode.previous = previousNode;
		previousNode.next = newNode;
		lastNode = newNode;

	}

	@Override
	public void insertAtRevPos(int val, int pos) {
		Node newNode = new Node(val);

		// if empty list then we insert the value as first element
		if (pos == 0 && lastNode == null) {
			firstNode = lastNode = newNode;
			size++;
			return;
		}
		// out of range
		if (pos != 0 && lastNode == null) {
			System.out.println("Index Out of Bounds");
			return;
		}

		if (pos == 0) {
			newNode.previous = lastNode;
			lastNode.next = newNode;
			lastNode = newNode;
			return;
		}
		int count = 0;

		Node currentNode = lastNode;
		Node previousNode = lastNode;

		while (currentNode != null) {

			if (count == pos) {

				newNode.next = previousNode;
				newNode.previous = currentNode;
				
				previousNode.previous = newNode;
				currentNode.next = newNode;
				
				// size++;
				return;
			}
			count++;
			previousNode = currentNode;
			currentNode = currentNode.previous;
		}

		// else insert at first
		newNode.previous = currentNode;
		newNode.next = previousNode;
		previousNode.previous = newNode;
		firstNode = newNode;

	}

	@Override
	public int findIndexFromFirst(int val) {
		Node currentNode = firstNode;
		int pos = 0;
		if (getSize() == 0) {
			System.out.println("Empty List");
			return -1;
		}

		// first Element
		if (currentNode.data == pos)
			return pos;

		while (currentNode.next != null) {
			if (currentNode.data == val)
				return pos;
			currentNode = currentNode.next;
			pos++;
		}
		if (currentNode.data != val) {
			System.out.println("Not Found");
			return -1;
		}
		return pos;
	}

	
	@Override
	public int findIndexFromLast(int val) {
		Node currentNode = lastNode;
		int pos = 0;
		if (lastNode == null) {
			System.out.println("Empty List");
			return -1;
		}

		// first Element
		if (currentNode.data == pos)
			return pos;

		while (currentNode.previous != null) {
			if (currentNode.data == val)
				return pos;
			currentNode = currentNode.previous;
			pos++;
		}
		if (currentNode.data != val) {
			System.out.println("Not Found");
			return -1;
		}
		return pos;
	}

	
	
	@Override
	public int findValAtPosFromFirst(int pos) {
		if (pos >= size || pos < 0) {
			System.out.println("Index out of Bounds");
			return -1;
		}
		int count = 0;
		if (pos == 0)
			return firstNode.data;
		else if (pos == size - 1)
			return lastNode.data;

		Node currentNode = firstNode;
		while (currentNode.next != null) {
			if (count == pos)
				return currentNode.data;
			currentNode = currentNode.next;
			count++;
		}

		return -1;
	}
	
	@Override
	public int findValAtPosFromLast(int pos) {
		
		if (lastNode == null || pos < 0) {
			System.out.println("Index out of Bounds");
			return -1;
		}
		int count = 0;
		if (pos == 0)
			return lastNode.data;
		

		Node currentNode = lastNode;
		
		while (currentNode != null) {
			if (count == pos)
				return currentNode.data;
			currentNode = currentNode.previous;
			count++;
		}

		return -1;
	}

	@Override
	public void traverse() {
		Node first = firstNode;
		while (first != null) {
			first.printNode();
			first = first.next;
		}
		System.out.println();
	}

	@Override
	public void traverseBack() {
		Node last = lastNode;
		while (last != null) {
			last.printNode();
			last = last.previous;
		}
		System.out.println();
	}

	
	@Override
	public void deleteAllOccur(int val) {

		while (firstNode != null && firstNode.data == val) {
			firstNode = firstNode.next;
			size--;
			if (size == 1)
				lastNode = firstNode;
			else if (size == 0)
				lastNode = firstNode = null;
		}

		if (firstNode == null)
			return;

		if (firstNode == lastNode && firstNode.data != val)
			return;

		Node currentNode = firstNode;
		Node previousNode = firstNode;

		while (currentNode.next != null) {
			if (currentNode.data == val) {
				previousNode.next = currentNode.next;
				currentNode = previousNode;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;

		}
		if (currentNode.data == val) {
			previousNode.next = null;
			lastNode = previousNode;
		}
	}

	@Override
	public void deleteFirstOccurFromFirst(int val) {
		if (firstNode != null && firstNode.data == val) {
			firstNode = firstNode.next;
			
			if (firstNode == null)
				lastNode = firstNode;
			else
				firstNode.previous = null;
			return;
		}

		Node currentNode = firstNode;
		Node previousNode = firstNode;

		while (currentNode != null) {
			if (currentNode.data == val) {
				previousNode.next = currentNode.next;
				currentNode = previousNode;
				if (currentNode.next == null) {
					lastNode = currentNode;
				}
				return;
			}

			previousNode = currentNode;
			currentNode = currentNode.next;
		}
	}
	
	@Override
	public void deleteFirstOccurFromLast(int val) {
		if (lastNode != null && lastNode.data == val) {
			lastNode = lastNode.previous;
			if (lastNode == null)
				lastNode = firstNode;
			else
				lastNode.next = null;
			return;
		}

		Node currentNode = lastNode;
		Node previousNode = lastNode;

		while (currentNode != null) {
			if (currentNode.data == val) {
				previousNode.previous = currentNode.previous;
				if(currentNode.previous != null){
				    currentNode.previous.next = previousNode;
				}
				if (currentNode.previous == null) {
					firstNode = previousNode;
				}
				return;
			}

			previousNode = currentNode;
			currentNode = currentNode.previous;
		}
	}

	@Override
	public void deleteHead() {
		if (firstNode != null) {
			firstNode = firstNode.next;
			if (firstNode == null)
				lastNode = firstNode;
			firstNode.previous = null;
		}
	}

	@Override
	public void deleteTail() {
		Node currentNode = lastNode;
		
		if (lastNode == null)
			return;
		
		Node previousNode = lastNode.previous;
		
		// or previousNode == null
		if (lastNode != null && firstNode == lastNode) {
			firstNode = lastNode = null;
			return;
		}

		lastNode = previousNode;
		lastNode.next = null;
		
	}

	@Override
	public void deleteAll() {
		firstNode = lastNode = null;
		size = 0;
	}

}