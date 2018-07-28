package ds.linkedlist;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst(5);
		list.addFirst(6);
		list.addFirst(8);
		list.addFirst(9);
		list.printList();
		
		list.deleteFirst();
		list.deleteFirst();
		list.printList();
		System.out.println(list.find(6));
		System.out.println(list.find(1));
		System.out.println(list.isEmpty());
		System.out.println(list.size);
		list.deleteFirst();
		list.deleteFirst();
		System.out.println(list.isEmpty());
		System.out.println(list.size);
		
		
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
	int size;
	public LinkedList() {
		firstNode = null;
		size = 0;
	}
	
	public void addFirst(int data){
		Node newNode = new Node(data);
		newNode.next = firstNode;
		firstNode = newNode;
		size++;
	}
	public void deleteFirst(){
		Node first = firstNode;
		firstNode = firstNode.next;
		size--;
		System.out.println("Delete: " + first.data);
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
