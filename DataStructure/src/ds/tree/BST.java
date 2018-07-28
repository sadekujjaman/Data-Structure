package ds.tree;

import java.util.Scanner;

public class BST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Node root = null;
		while(num-->0){
			int data = sc.nextInt();
			root = insert(root, data);
		}
		
		
		
		sc.close();
	}
	public static  Node insert(Node root, int data){
		if(root == null){
			return new Node(data);
		}
		else{
			Node currentNode;
			if(root.data >= data){
		       currentNode = insert(root.left, data); 
		       root = currentNode;
			}
			else{
				currentNode = insert(root.right, data);
				root = currentNode;
			}
			return root;
		}
	}

}

class Node{
	 Node left;
	 Node right;
	 int data;
	
	public Node(int data) {
		this.data = data;
		left = right = null;
	}
	
}
