import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Saju
 *
 */

public class Main {

	// static int[] dx = { 0, 1, 0, -1 };
	// static int[] dy = { -1, 0, 1, 0 };
	//
	// static int[] ddx = { 0, 1, 0, -1, -1, 1, 1, -1 };
	// static int[] ddy = { -1, 0, 1, 0, -1, -1, 1, 1 };
	//
	// static int[] kx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	// static int[] ky = { 1, 2, 2, 1, -1, -2, -2, -1 };
	//
	static long MOD = (long) Math.pow(2, 32);
	//
	// static final int MAX = 1000007;
	// static long INF = Long.MAX_VALUE;
	static int INT_INF = Integer.MAX_VALUE;
	// static double PI = 3.1415926535;
	//
	// private static final double EPSILON = 1e-10;
	//
	// private static double dp[] = new double[MAX];

	private static final int MAXN = 1000007;
	private static final int MAXA = 1000009;
	private static final int MAXLOG = 22;

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

/*



*/
		text = in.next();
		pattern = String.valueOf(text);
		String ans = kmpSearch();
		if(ans == null){
			out.println("Just a legend");
		}
		else{
			out.println(ans);
		}
		out.flush();
		out.close();
		System.exit(0);
	}

	static int[] prefixTable = new int[1000005];
	  
	private static long[] tree = new long[MAXN << 2];
	private static long[] lazy = new long[MAXN << 2];

	private static long[] arr = new long[MAXN];

	private static long[] min = new long[MAXN << 2];
	private static long[] max = new long[MAXN << 2];

	static String text = "";
    static String pattern = "";
   
    
	 private static String  kmpSearch() {
	       
	        kmpPreprocess();
	       
	       
	        int n = text.length(); 
	        
	        // If lps of n-1 is zero 
	        if (prefixTable[n - 1] == 0) 
	        { 
//	            System.out.println(-1); 
	            return null; 
	        } 
	        for (int i = 0; i < n - 1; i++)  
	        { 
	      
	            // At any position lps[i] equals to lps[n - 1] 
	            if (prefixTable[i] == prefixTable[n - 1])  
	            { 
//	                System.out.println(text.substring(0, prefixTable[i] + 1)); 
	                return text.substring(0, prefixTable[i]); 
	            } 
	        } 
	      
	        // If answer is not possible 
	        if (prefixTable[prefixTable[n - 1] - 1] == 0) {
//	            System.out.println(-1); 
	        	return null;
	        }
	        else{
	            return text.substring(0, prefixTable[prefixTable[n - 1] - 1]);
	        }
	    }
	 
	 private static void kmpPreprocess() {
	       
		 int n = pattern.length(); 
	      
	        // To store longest prefix suffix 
//	        int [] lps = new int [n]; 
	      
	        // Length of the previous 
	        // longest prefix suffix 
	        int len = 0; 
	      
	        // lps[0] is always 0
	        prefixTable[0] = 0; 
	        int i = 1; 
	      
	        // Loop calculates lps[i] for i = 1 to n - 1 
	        while (i < n)  
	        { 
	            if (pattern.charAt(i) == pattern.charAt(len))  
	            { 
	                len++; 
	                prefixTable[i] = len; 
	                i++; 
	            } 
	      
	            // (pat[i] != pat[len]) 
	            else 
	            { 
	                if (len != 0) 
	                    len = prefixTable[len - 1]; 
	                // Also, note that we do not increment 
	                // i here 
	      
	                // If len = 0 
	                else
	                { 
	                    prefixTable[i] = 0; 
	                    i++; 
	                } 
	            } 
	        } 
	    }
	
	 private static int countSubstring(String str, String pattern) {
	       
	        generatePrefixTable(pattern);
	       
	        int n = str.length();
	        int m = pattern.length();
	       
	        int i = 0;
	        int j = 0;
	        int count = 0;
	       
	        while(i < n){
	            if(str.charAt(i) == pattern.charAt(j)){
	                if(j == m - 1){
	                    count++;
	                    j = prefixTable[j - 1];
	                    continue;
	                }
	                i++;
	                j++;
	            }
	            else if(j > 0){
	                j = prefixTable[j - 1];
	            }
	            else{
	             i++;
	             
	            }
	        }
	       
	        return count;
	    }
	 
	private static void generatePrefixTable(String pattern) {
        char[] patternArr = pattern.toCharArray();
        int n = pattern.length();
       
        int i = 1;
        int j = 0;
        prefixTable[0] = 0;
       
        while(i < n){
            if(patternArr[i] == patternArr[j]){
                prefixTable[i] = j + 1;
                i++;
                j++;
            }
            else if(j > 0){
                j = prefixTable[j - 1];
            }
            else{
                i++;
               
            }
        }
    }
 
	
	
	private static void build(int node, int low, int high) {
		if (low == high) {
			min[node] = arr[low];
			max[node] = arr[low];
			return;
		}

		int mid = (low + high) / 2;
		int left = node << 1;
		int right = left | 1;
		build(left, low, mid);
		build(right, mid + 1, high);
		max[node] = max(max[left], max[right]);
		min[node] = min(min[left], min[right]);
	}

	private static void update(int node, int value, int x, int y, int low, int high) {

		if (low > high) {
			return;
		}
		int mid = (low + high) / 2;
		int left = node << 1;
		int right = left | 1;

		if (lazy[node] != -1) {
			tree[node] = (high - low + 1) * lazy[node];
			if (low != high && high > low) {
				lazy[left] = lazy[node];
				lazy[right] = lazy[node];
			}
			lazy[node] = -1;
		}

		if (low > y || high < x) {
			return;
		}

		if (low >= x && high <= y) {
			tree[node] = (high - low + 1) * value;
			if (low != high && high > low) {
				lazy[left] = value;
				lazy[right] = value;
			}
			return;

		}
		update(left, value, x, y, low, mid);
		update(right, value, x, y, mid + 1, high);
		tree[node] = tree[left] + tree[right];
	}

//	private static void propagate(int node, int low, int high) {
//		if(tree[node].lazyValue == 0){
//			return;
//		}
//		int mid = (low + high)/2;
//		int left = node << 1;
//		int right = left | 1;
//		 
//	    if(tree[node].lazyValue == 1)
//	    {
//	        tree[node].twoCount = tree[node].oneCount;
//	        tree[node].oneCount = tree[node].zeroCount;
//	        tree[node].zeroCount = (high - low + 1) - (tree[node].oneCount + tree[node].twoCount);
//	    }
//	    else
//	    {
//	    	tree[node].oneCount = tree[node].twoCount;
//	    	tree[node].twoCount = tree[node].zeroCount;
//	    	tree[node].zeroCount = (high - low + 1) - (tree[node].oneCount + tree[node].twoCount);
//	    }
//	 
//	    if(low != high)
//	    {
//	        tree[left].lazyValue += tree[node].lazyValue;
//	        tree[right].lazyValue += tree[node].lazyValue;
//	 
//	        tree[left].lazyValue %= 3;
//	        tree[right].lazyValue %= 3;
//	    }
//	    tree[node].lazyValue = 0;
//	}

	private static Pair query(int node, int x, int y, int low, int high) {
		// System.out.println(node + " " + low + " " + high);
		if (low > high) {
			return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);
		}
		int mid = (low + high) / 2;
		int left = node << 1;
		int right = left | 1;

		// propagate(node, low, high);

		// if(lazy[node] != -1){
		// tree[node] = (high - low + 1) * lazy[node];
		// if(low != high && high > low){
		// lazy[left] = lazy[node];
		// lazy[right] = lazy[node];
		// }
		// lazy[node] = -1;
		// }

		if (low > y || high < x) {
			return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);
		}

		if (low >= x && high <= y) {
			return new Pair(max[node], min[node]);
		}

		Pair leftValue = query(left, x, y, low, mid);
		Pair rightValue = query(right, x, y, mid + 1, high);
		return new Pair(max(leftValue.max, rightValue.max), min(leftValue.min, rightValue.min));
	}

	private static class Node {
		long nodeValue;
		long lazyValue;

		Node() {
			this.nodeValue = 0;
			this.lazyValue = 0;
		}

		Node(long nodeValue, long lazyValue) {
			this.nodeValue = nodeValue;
			this.lazyValue = lazyValue;
		}

	}

	// cycle detection of a graph
	private static boolean detectCycleOfGraph(int n, int m, List<Integer>[] adj) {
		int vertices = n * m;
		boolean[] visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				if (dfsForDetectCycle(i, -1, adj, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	// dfs for cycle detection of a graph
	private static boolean dfsForDetectCycle(int u, int parent, List<Integer>[] adj, boolean[] visited) {
		visited[u] = true;
		for (int v : adj[u]) {
			if (v != parent) {
				if (visited[v]) {
					return true;
				}
				if (dfsForDetectCycle(v, u, adj, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static Matrix matrixPower(Matrix matrix, long x) {
		int rows = matrix.rows;
		int cols = matrix.cols;
		long arr[][] = new long[rows][cols];
		for (int i = 0; i < rows; i++) {
			arr[i][i] = 1;
		}
		Matrix result = new Matrix(rows, cols, arr);
		while (x > 0) {
			if (x % 2 == 1) {
				result = result.multiply(matrix);
			}
			matrix = matrix.multiply(matrix);
			x /= 2;
		}
		return result;
	}

	// nCk
	private static long binomialCoeff(int n, int k) {
		long[] arr = new long[k + 1];
		arr[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, k); j > 0; j--) {
				arr[j] = (arr[j] + arr[j - 1]);
			}
		}
		return arr[k];
	}

	private static class Matrix {
		long mat[][];
		int rows;
		int cols;

		Matrix(int rows, int cols) {
			this.rows = rows;
			this.cols = cols;
			mat = new long[rows][cols];
		}

		Matrix(int rows, int cols, long[][] mat) {
			this.rows = rows;
			this.cols = cols;
			this.mat = mat;
		}

		Matrix multiply(Matrix anotherMat) {
			int n = this.rows;
			int m = anotherMat.cols;
			long arr[][] = new long[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					long val = 0;
					for (int k = 0; k < this.cols; k++) {
						val = (val + (this.mat[i][k] % MOD * anotherMat.mat[k][j] % MOD) % MOD) % MOD;
					}
					arr[i][j] = val % MOD;
				}
			}
			return new Matrix(n, m, arr);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.cols; j++) {
					sb.append(this.mat[i][j] + " ");
				}
				sb.append("\n");
			}
			return sb.toString();
		}
	}

	private static class Pair {
		long max;
		long min;

		Pair() {
			max = Long.MIN_VALUE;
			min = Long.MAX_VALUE;
		}

		Pair(long max, long min) {
			this.max = max;
			this.min = min;
		}
	}

	private static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {

			return this.x + " " + this.y;
		}
	}

	private static int log(int x, int base) {
		return (int) (Math.log(x) / Math.log(base));
	}

	private static long max(long a, long b) {
		if (a >= b) {
			return a;
		}
		return b;
	}

	private static long min(long a, long b) {
		if (a <= b) {
			return a;
		}
		return b;
	}
	private static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	// private static long bigMod(long n, long k, long m) {
	//
	// long ans = 1;
	// while (k > 0) {
	// if ((k & 1) == 1) {
	// ans = (ans * n) % m;
	// }
	// n = (n * n) % m;
	// k >>= 1;
	// }
	// return ans;
	// }

	/*
	 * Returns an iterator pointing to the first element in the range [first,
	 * last] which does not compare less than val.
	 * 
	 */
	private static int lowerBoundNew(long[] arr, long num) {
		int start = 0;
		int end = arr.length - 1;
		int index = 0;
		int len = arr.length;
		int mid = 0;
		while (true) {
			if (start > end) {
				break;
			}
			mid = (start + end) / 2;
			if (arr[mid] > num) {
				end = mid - 1;
			} else if (arr[mid] < num) {
				start = mid + 1;
			} else {
				while (mid >= 0 && arr[mid] == num) {
					mid--;
				}
				return mid + 1;
			}
		}
		if (arr[mid] < num) {
			return mid + 1;
		}
		return mid;
	}

	/*
	 * upper_bound() is a standard library function in C++ defined in the header
	 * . It returns an iterator pointing to the first element in the range
	 * [first, last) that is greater than value, or last if no such element is
	 * found
	 * 
	 */
	private static int upperBoundNew(long[] arr, long num) {

		int start = 0;
		int end = arr.length - 1;
		int index = 0;
		int len = arr.length;
		int mid = 0;
		while (true) {
			if (start > end) {
				break;
			}
			mid = (start + end) / 2;
			if (arr[mid] > num) {
				end = mid - 1;
			} else if (arr[mid] < num) {
				start = mid + 1;
			} else {
				while (mid < len && arr[mid] == num) {
					mid++;
				}
				if (mid == len - 1 && arr[mid] == num) {
					return mid + 1;
				} else {
					return mid;
				}
			}
		}
		if (arr[mid] < num) {
			return mid + 1;
		}
		return mid;
	}

	private static class InputReader {
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
