package ds.tree;

import java.util.Scanner;

public class SegmentTree {

	static int[] tree = new int[2000005];
	static int[] A = new int[100005];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int N = sc.nextInt();
		int Q = sc.nextInt();
		
		for(int i = 1; i <= N; i++){
			A[i] = sc.nextInt();
			
		}
		build(1, 1, N);
//		for(int i = 1; i <= 2 * N + 1; i++){
//			System.out.print(tree[i] + " ");
//			
//		}
//		System.out.println();
		for(int i = 0; i < Q; i++){
			char q = sc.next().charAt(0);
		    switch(q){
		    
		    case 'q':
		    	int left = sc.nextInt();
		    	int right = sc.nextInt();
		    	int ans = query(1, 1, N, left, right);
		    	System.out.println(ans);
		    	break;
		    case 'u':
		    	int idx = sc.nextInt();
		    	int val = sc.nextInt();
		    	update(1, 1, N, idx, val);
		    	break;
		    }
		}
		
		sc.close();
	}
	
	private static void build(int node, int start, int end){
		if(start == end){
			tree[node] = A[start];
		}
		else{
			int mid = (start + end) / 2;
			build((2 * node), start, mid);
			build((2 * node) + 1, mid + 1, end);
			
			tree[node] = Math.min(tree[(2 * node)], tree[(2 * node) + 1]);
			
		}
	}
	
	private static void update(int node, int start, int end, int idx, int val){
		
		if(start == end){
			A[idx] = val;
			tree[node] = val;
		}
		else{
			int mid = (start + end) / 2;
			
			if(start <= idx && mid >= idx)
			    update(2 * node, start, mid, idx, val);
			else 
			   update((2 * node) + 1, mid + 1, end, idx, val);
			
			tree[node] = Math.min(tree[2 * node], tree[(2 * node) + 1]);
			
		}
		
	}
	
	private static int query(int node, int start, int end, int left, int right){
	
		if(right < start  || end < left)
			return 1000000;
		if(left <= start && end <= right)
			return tree[node];
		
		int mid = (start + end) / 2;
		int val1 = query(2 * node, start, mid, left, right);
		int val2 = query((2 * node) + 1, mid + 1, end, left, right);
		
		return Math.min(val1, val2);
	}

}
