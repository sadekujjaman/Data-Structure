package ds.tree;

import java.io.*;
import java.util.*;


/**
 *
 * @author Saju
 *
 */


public class LCA {


	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);

		/*
13 5
1 2
1 3
2 4
2 5
2 6
3 7
3 8
4 9
5 10
5 11
9 12
9 13
12 5
		
		*/

		int n = in.nextInt();
		int m = in.nextInt();
		
		List<Integer> adj[] = new ArrayList[n];
		for(int i = 0; i < n; i++){
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < n - 1; i++){
			int u = in.nextInt();
			int v = in.nextInt();
			u--;
			v--;
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int parent[] = new int[n];
		int level[] = new int[n];
		
		Arrays.fill(parent, -1);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		boolean visited[] = new boolean[n];
		visited[0] = true;
		
		while(!queue.isEmpty()){
			int u = queue.remove();
			for(Integer v : adj[u]){
				if(!visited[v]){
					visited[v] = true;
					queue.add(v);
					parent[v] = u;
					level[v] = level[u] + 1;
				}
			}
		}
		
		int pp[][] = new int[n][22];
		
		int log2n = log(n, 2) + 1;

		for(int i = 0; i < n; i++){
			pp[i][0] = parent[i];
		}
		
		for(int j = 1; j < log2n; j++){
			for(int i = 0; i < n; i++){
				if(pp[i][j - 1] != -1){
					pp[i][j] = pp[pp[i][j - 1]][j - 1];
				}
				
			}
		}
		
//		System.out.println(Arrays.toString(level));
//		System.out.println(Arrays.toString(parent));
//		
//		for(int i = 0; i < n; i++){
//			System.out.println(Arrays.toString(pp[i]));
//		}
		
		
		for(int i = 0; i < m; i++){
			int p = in.nextInt();
			int q = in.nextInt();
			
			p--;
			q--;
			
			 
			
			if(level[p] < level[q]){
				int temp = p;
				p = q;
				q = temp;
			}
			
			for(int j = log2n; j >= 0; j--){
				if ((level[p] - (1 << j)) >= level[q]) {
					 p =  pp[p][j];
				}
			}
//			System.out.println((p + 1) + " " + (q + 1));
			
			for(int j = log2n; j >= 0; j--){
				if(pp[p][j] != pp[q][j]){
					p = pp[p][j];
					q = pp[q][j];
				}
			}
//			System.out.println(p + " " + q);
			
			System.out.println((parent[p] + 1));
		}
		
		System.exit(0);
	}

	static int getKthParent(int n, int u, int v, int k, int[] parent, int[] level, int[][] pp){
		int lca = getLCA(n, u, v, parent, level, pp);
		if(level[u] - level[lca] <= k - 1){
			int temp = u;
			u = v;
			v = temp;
			k = 1 + level[u] + level[v] - (2 * level[lca]) - k;
		}else{
			k--;
		}
		for(int i = 0; (1<<i) <= k; i++) {
	        if((k & (1 << i)) >= 1) {
	            u = pp[u][i];
	        }
	    }
		return (u + 1); // 
	}

	private static int getLCA(int n, int p, int q, int[] parent, int[] level, int[][] pp) {
		int log2n = log(n, 2) + 1;
		if(level[p] < level[q]){
			int temp = p;
			p = q;
			q = temp;
		}
		for(int j = log2n; j >= 0; j--){
			if ((level[p] - (1 << j)) >= level[q]) {
				p =  pp[p][j];
			}
		}
		
		if(p == q){
			return p;
		}
//		System.out.println((p + 1) + " " + (q + 1));
		
		for(int j = log2n; j >= 0; j--){
			if(pp[p][j] != pp[q][j]){
				p = pp[p][j];
				q = pp[q][j];
			}
		}
//		System.out.println(p + " " + q);
		
		return parent[p];
	}

	
	private static int log(int x, int base)
	{
	    return (int) (Math.log(x) / Math.log(base));
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens()) {
					tokenizer = new StringTokenizer(reader.readLine());

				}
			} catch (IOException e) {
				return null;
			}
			return tokenizer.nextToken();
		}

		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
				line = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public boolean hasNext() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens()) {
					tokenizer = new StringTokenizer(reader.readLine());
				}
			} catch (Exception e) {
				return false;
			}
			return true;
		}
	}
}
