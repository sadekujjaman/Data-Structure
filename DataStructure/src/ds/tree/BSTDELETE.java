/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.tree;

import java.util.Scanner;

/**
 *
 * @author Saju
 */
public class BSTDELETE {
    
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Node root = null;
		while(num-->0){
			int data = sc.nextInt();
			root = insert(root, data);
		}
//                System.out.println(root.data);
                System.out.println();
                System.out.println("");
                printData(root);
		System.out.println("");
                
                System.out.println("");
               root = delete(root, 50);
                
                System.out.println();
                System.out.println("");
                printData(root);
		System.out.println("");
		
		sc.close();
	}
    
    private static void printData(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        printData(root.left);
        printData(root.right);
    }
	private static  Node insert(Node root, int data){
		if(root == null){
			return new Node(data);
		}
		else{
			Node curr = root;
                        Node prev = root;
                        while(curr != null){
                            prev = curr;
                            if(curr.data > data){
                                curr = curr.left;
                            }
                            else if(curr.data < data){
                                curr = curr.right;
                            }
                        }
                        
                        if(prev.data > data){
                            prev.left = new Node(data);
                        }
                        else if(prev.data < data){
                            prev.right = new Node(data);
                        }
                        
			return root;
		}
	}
        
        private static Node delete(Node root, int data){
            
             Node curr = root;
             Node prev = root;
             
             while(curr != null){
                 prev = curr;
                 if(curr.data < data){
                     
                     curr = curr.right;
                 }
                 else if(curr.data > data){
                     curr = curr.left;
                 }
                 else if(curr.data == data){
                     System.out.println("break");
                     break;
                     
                 }
                 
             }
             
             // child node
             if(curr.left == null && curr.right == null){
                 System.out.println("Leaf");
                 if(prev.data > curr.data){
                     prev.left = null;
                 }
                 else if(prev.data < curr.data){
                     prev.right = null;
                 }
                 
             }
             // one  right child
             else if(curr.left == null && curr.right != null){
                 if(prev.data > curr.data){
                     prev.left = curr.right;
                 }
                 else if(prev.data < curr.data){
                     prev.right = curr.right;
                 }
             }
             // one left child
             else if(curr.left != null && curr.right == null){
                 if(prev.data > curr.data){
                     prev.left = curr.left;
                 }
                 else if(prev.data < curr.data){
                     prev.right = curr.left;
                 }
             }
             // two child
             else if(curr.left != null && curr.right != null){
                 
                 Node leftMost = curr.right;
                 while(leftMost.left != null){
                     leftMost = leftMost.left;
                 }
                 
                 int leftMostData = leftMost.data;
                 delete(root, leftMostData);
                 
                 Node n = new Node(leftMostData);
                 n.left = curr.left;
                 n.right = curr.right;
                 
                 if(prev.data > curr.data){
                     prev.left = n;
                 }
                 else if(prev.data < curr.data){
                     prev.right = n;
                 }
                 
             }
             
            
             return root;
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
