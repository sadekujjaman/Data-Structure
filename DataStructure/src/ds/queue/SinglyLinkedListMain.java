package ds.queue;

public class SinglyLinkedListMain {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
      //   ---> 1 <-----		
//		list.insertVal(5);
//		list.insertVal(8);
//		list.insertVal(10);
		
	  // ----> 2 <-----
//		list.insertValBeforeTail(5);
//		list.insertValBeforeTail(10);
//		list.insertValBeforeTail(15);
//		list.insertValBeforeTail(20);
		
	 // ----> 3 <------
//		list.insertAtHead(50);
//		list.insertAtHead(15);
//		list.insertAtHead(22);
//		list.insertAtHead(11);
		
	 // -----> 4 <-------
//	    list.insertAfterHead(33);
//	    list.insertAfterHead(44);
//	    list.insertAfterHead(55);
//	    list.insertAfterHead(66);
		
	// -----> 5 <---------
//		list.insertAtPos(23, 0);
//		list.insertAtPos(12, 0);
//		list.insertAtPos(32, 2);
//		list.insertAtPos(24, 2);
		
		
	// -----> 6 <------
//		System.out.println(list.findIndex(5));
//	    list.insertVal(5);
//	    list.insertVal(20);
//	    list.insertVal(23);
//		System.out.println(list.findIndex(5));
//		System.out.println(list.findIndex(23));
//		System.out.println(list.findIndex(24));
		
	// -----> 7 <------
//		list.findValAtPos(0);
//		list.insertVal(5);
//	    list.insertVal(20);
//	    list.insertVal(23);
//	    System.out.println(list.findValAtPos(0));
//	    System.out.println(list.findValAtPos(2));
//	    System.out.println(list.findValAtPos(3));
		
    // ------> 8 <------
//		list.insertVal(3);
//		list.insertVal(3);
//		list.insertVal(3);
//		list.traverse();
//		list.deleteAllOccur(3);
//		list.traverse();
//		list.insertVal(4);
//		list.insertVal(5);
//		list.insertVal(5);
//		list.insertVal(5);
//		list.traverse();
//		list.deleteAllOccur(5);
//		list.traverse();
//		list.insertVal(6);
//		list.insertVal(9);
//		list.insertVal(9);
//		list.insertVal(10);
//		list.traverse();
//		list.deleteAllOccur(9);
//		list.traverse();
//		list.insertVal(4);
//		list.insertVal(11);
//		list.insertVal(11);
//		list.insertVal(13);
//		list.insertVal(13);
//		list.traverse();
//		list.deleteFirstOccur(4);
//		list.deleteFirstOccur(13);
//		list.traverse();
//		list.deleteHead();
//		list.deleteTail();
//		list.traverse();
//		list.deleteAll();
		
		list.insertVal(4);
		list.insertVal(6);
		list.insertVal(8);
		list.insertVal(11);
		list.traverse();
		list.deletePos(0);
		list.insertVal(15);
		list.traverse();
		list.deletePos(2);
	    list.traverse();
	    list.deletePos(2);
	    list.traverse();
		
		System.out.println("Thanks!!");
		list.traverse();	
	}

}

class Node{
	
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	public void printNode(){
		System.out.print( this.data + " ");
	}
	
}
class LinkedList implements SinglyLinkedListInterface{
	
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
		if(firstNode == null){
			firstNode = newNode;
			lastNode = newNode;
		}
		else{
			lastNode.next = newNode;
		    lastNode = newNode;
		}
		size++;
	}

	@Override
	public void insertValBeforeTail(int val) {
		Node newNode = new Node(val);
		// empty list
		if(lastNode == null && firstNode == null){
			firstNode = lastNode = newNode;
		}
		    // one element
		else if(firstNode == lastNode && firstNode != null){
			firstNode = newNode;
			firstNode.next = lastNode;
		}
		else{
			Node currentNode = firstNode;
			while(currentNode.next.next != null){
				currentNode = currentNode.next;
			}
			Node nextNode = currentNode.next;
			currentNode.next = newNode;
			newNode.next = nextNode;
			
		}
		size++;
		
	}

	@Override
	public void insertAtHead(int val) {
		Node newNode = new Node(val);
		// empty list
		if(firstNode == null && lastNode == null){
			firstNode = lastNode = newNode;
		}
		// one element
		else if(firstNode == lastNode && lastNode != null){
			firstNode = newNode;
			firstNode.next = lastNode;
		}
		else{
			newNode.next = firstNode;
			firstNode = newNode;
		}
		size++;
		
	}

	@Override
	public void insertAfterHead(int val) {
		Node newNode = new Node(val);
		// empty list
		if(firstNode == null && lastNode == null){
			firstNode = lastNode = newNode;
		}
		// one element
		else if(firstNode == lastNode && lastNode != null){
			firstNode.next = newNode;
			lastNode = newNode;
		}
		else{
			Node next = firstNode.next;
			firstNode.next = newNode;
			newNode.next = next;
		}
		size++;
	}
	
	
	
	
	int getSize(){
		return size;
	}
	void printSize(){
		System.out.println("Size: " + size);
	}

	
	
	
	
	@Override
	public void insertAtPos(int val, int pos) {
		
		Node newNode = new Node(val);
		
		// if empty list then we insert the value as first element
		if((size == 0 && pos == 0)  && firstNode == null)
		{
			firstNode = lastNode = newNode;
		    size++;
		    return;
		}
		// out of range
		if(pos > getSize()){
			System.out.println("Index Out of Bounds");
			return;
		}
		
		int count = 0;
		
		Node currentNode = firstNode;
		while(currentNode.next != null){
			count++;
			if(count == pos){
		        newNode.next = currentNode.next;
		        currentNode.next = newNode;
		        size++;
		        return;
			}
			currentNode = currentNode.next;
		}
		// one element contains but want insert 0 position
		if(pos == 0){
			
			newNode.next = currentNode;
			firstNode = newNode;
			size++;
			return;
		}
		
		// insert as last element
	     if(size != 0 && size == pos){
				currentNode.next = newNode;
				lastNode = newNode;
				size++;
		}
		
		
	}

	@Override
	public int findIndex(int val) {
		Node currentNode = firstNode;
		int pos = 0;
		if(getSize() == 0){
			System.out.println("Empty List");
			return -1;
		}
		
		// first Element
		if(currentNode.data == pos)
			return pos;
		
		while(currentNode.next != null){
			if(currentNode.data == val)
				return pos;
			currentNode = currentNode.next;
			pos++;
		}
		if(currentNode.data != val){
			System.out.println("Not Found");
			return -1;
		}
		return pos;
	}

	@Override
	public int findValAtPos(int pos) {
		if(pos >= size || pos < 0){
			System.out.println("Index out of Bounds");
			return -1;
		}
		int count = 0;
		if(pos == 0)
			return firstNode.data;
		else if(pos == size - 1)
			return lastNode.data;
		
		Node currentNode = firstNode;
		while(currentNode.next != null){
			if(count == pos)
				return currentNode.data;
			currentNode = currentNode.next;
			count++;
		}
		
		return -1;
	}

	@Override
	public void traverse() {
		Node first = firstNode;
		while(first != null){
			first.printNode();
			first = first.next;
		}
		System.out.println();
	}

	@Override
	public void deleteAllOccur(int val) {
		
		while(firstNode != null && firstNode.data == val){
			firstNode = firstNode.next;
			size--;
			if(size == 1)
				lastNode = firstNode;
			else if(size == 0)
				lastNode = firstNode = null;
		}
		
		if(firstNode == null)
			return;
		
		if(firstNode == lastNode && firstNode.data != val)
			return;
		
		Node currentNode = firstNode;
		Node previousNode = firstNode;
		
		
		while(currentNode.next != null){
			if(currentNode.data == val){
				previousNode.next = currentNode.next;
				currentNode = previousNode;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
			
		}
		if(currentNode.data == val){
			previousNode.next = null;
			lastNode = previousNode;
		}
	}

	@Override
	public void deleteFirstOccur(int val) {
		if(firstNode != null && firstNode.data == val){
			firstNode = firstNode.next;
			if(firstNode == null)
				lastNode = firstNode;
			return;
		}
		
		Node currentNode = firstNode;
		Node previousNode = firstNode;
		
		while(currentNode != null){
			if(currentNode.data == val){
				previousNode.next = currentNode.next;
				currentNode = previousNode;
				if(currentNode.next == null){
					lastNode = currentNode;
				}
				return;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
	}
	
	@Override
	public void deletePos(int pos){
		Node currentNode = firstNode;
		Node previousNode = firstNode;
		int count = 0;
		if(firstNode != null && pos == 0){
			firstNode = firstNode.next;
			if(firstNode == null)
				lastNode = firstNode;
			
			return;
		}
		
		while(currentNode != null){
			if(count == pos){
				previousNode.next = currentNode.next;
			  if(currentNode.next == null){
					lastNode = previousNode;
				}
				return;
			}
			count++;
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
	}

	@Override
	public void deleteHead() {
		if(firstNode != null){
		    firstNode = firstNode.next;
		    if(firstNode == null)
		    	lastNode = firstNode;
		}
	}

	@Override
	public void deleteTail() {
		Node currentNode = firstNode;
		Node previousNode = firstNode;
		
		if(firstNode == null)
			return;
		if(firstNode != null && firstNode == lastNode){
			firstNode = lastNode = null;
			return;
		}
		
		while(currentNode.next != null){
			
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		
		previousNode.next = currentNode.next;
		lastNode = previousNode;
		
	}

	@Override
	public void deleteAll() {
		firstNode = lastNode = null;
		size = 0;
	}
	
}
