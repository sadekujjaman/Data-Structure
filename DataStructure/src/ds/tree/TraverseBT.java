package ds.tree;

import java.util.Stack;

public class TraverseBT {

	public static void main(String[] args) {
		
		// start inserting from index 1
		int pos = 1;
		// see below for this tree
		for(int i = 1; i <= 15; i++){
			pos = insert(i * 10, pos);
		}
		
		// traverse preOrder
		System.out.print("Pre-Order: ");
		traversePreOrder();
		System.out.println();
		
		// traverse inOrder
		System.out.print("In-Order: ");
		traverseInOrder();
		System.out.println();
		
		// traverse postOrder
		System.out.print("Post-Order: ");
		traversePostOrder();
		System.out.println();
		
	}
	
	/**           
	 *  we handle this tree
	 *  
	 *                   10
	 *                         
	 *             /            \
	 *            20             30
	 *          /   \           /   \
	 *        40     50        60   70
	 *        /\     /\        /\    /\
	 *      80  90 100 110  120 130 140 150
	 *      
	 */
	private static Node[] sequence = new Node[40];
	
	/**
	 * 
	 * {@code
	 * insert a new node in the sequence 
	 * with specified data in specified position
	 * and return next position for insertion 
	 * }
	 * 
	 * @param data
	 * @param pos
	 * @return nextPos
	 * 
	 * 
	 * 
	 */
	private static int insert(int data, int pos){
		
		sequence[pos] = new Node(data, pos * 2, (pos * 2) + 1);
		int nextPos = pos + 1;
		return nextPos;
	}

	
	/**
	 * traverse tree in PreOrder
	 */
	private static void traversePreOrder(){
		Stack<Node> stack = new Stack<>();
		Node ptr = sequence[1]; // ptr := root
		
		while(ptr != null){
			System.out.print(ptr.data + " ");
			int leftIndex = ptr.leftIndex;
			int rightIndex = ptr.rightIndex;
			
			// check is there have right child
			// if have then push it onto stack
			if(sequence[rightIndex] != null){
				stack.push(sequence[rightIndex]);
			}
			if(sequence[leftIndex] != null){
				ptr = sequence[leftIndex];
			}
			else{
				if(!stack.isEmpty())
				   ptr = stack.pop();
				else
					ptr = null;
			}
		}
		
	}
	
	
	
	/**
	 * traverse tree in InOrder
	 */
	private static void traverseInOrder(){
		Stack<Node> stack = new Stack<>();
		Node ptr = sequence[1]; // ptr := root
		
		stack = processForInOrder(stack, ptr);
		
		ptr = stack.pop();
		while(ptr != null){
			System.out.print(ptr.data + " ");
			int rightIndex = ptr.rightIndex;
			if(sequence[rightIndex] != null){
				ptr = sequence[rightIndex];
				// go to prev while
				stack = processForInOrder(stack, ptr);
			}
			if(!stack.isEmpty())
			    ptr = stack.pop();
			else
				ptr = null;
		}
		
	}
	/**
	 * {@code
	 *  maintain processing for inOrder traverse
	 * }
	 * @param stack
	 * @param ptr
	 * @return
	 */
	private static Stack<Node> processForInOrder(Stack<Node> stack, Node ptr){
		while(ptr != null){
			stack.push(ptr);
			ptr = sequence[ptr.leftIndex];
		}
		return stack;
	}
	
	
	
	/**
	 * traverse tree in PostOrder
	 */
	private static void traversePostOrder(){
		Stack<Node> stack = new Stack<>();
		Node ptr = sequence[1]; // ptr := root
		
		stack = processForPostOrder(stack, ptr);
		
		ptr = stack.pop();
		
		while(ptr != null){
			while(ptr != null && ptr.negativeVal >= 0){
				System.out.print(ptr.data + " ");
				if(!stack.isEmpty())
				   ptr = stack.pop();
				else
					ptr = null;
			}
			if(ptr != null && ptr.negativeVal == -1){
				ptr.negativeVal = 0;
				stack = processForPostOrder(stack, ptr);
				ptr = stack.pop();
			}
		}
		
	}
	/**
	 * {@code
	 * maintain processing for PostOrder traverse
	 * }
	 * @param stack
	 * @param ptr
	 * @return
	 */
	private static Stack<Node> processForPostOrder(Stack<Node> stack, Node ptr){
		
		while(ptr != null){
			stack.push(ptr);
			int rightIndex = ptr.rightIndex;
			if(sequence[rightIndex] != null){
				Node n = sequence[rightIndex];
				n.negativeVal = -1;
				stack.push(n);
			}
			ptr = sequence[ptr.leftIndex];
		}
		
		return stack;
	}

	
	
	private static class Node{
		
		// for int data
		int data;
		int leftIndex;
		int rightIndex;
		
		// for postOrder
		int negativeVal = 0;
		
		public Node(int data, int leftIndex, int rightIndex) {
			this.data = data;
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
		}
		
	}

}
