package ds.queue;

public class LinkedListMain2 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insertLast(5);
		list.insertLast(6);
		list.insertLast(7);
		list.insertLast(8);
		
		list.printList();
	
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
class LinkedList{
	
	Node firstNode;
	Node lastNode;
	
	int size;
	public LinkedList() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	
	public void insertLast(int data){
		
		Node newNode = new Node(data);
		// empty list
		if(firstNode == null){
			firstNode = newNode;
			lastNode = newNode;
		}
		else{
			lastNode.next = newNode;
		    lastNode = newNode;
		}
	}
	
	public void deleteLast(){
		
	}
	public boolean find(int key){
		Node first = firstNode;
		while(first != null){
			if(first.data == key){
				return true;
			}
			first = first.next;
		}
		return false;
	}
	public boolean isEmpty(){
		return firstNode == null;
	}
	
	public void printList(){
		Node first = firstNode;
		while(first != null){
			first.printNode();
			first = first.next;
		}
		System.out.println();
	}
	
}
