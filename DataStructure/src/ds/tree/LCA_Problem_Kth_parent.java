import java.io.*;
import java.math.*;
import java.util.*;

/**
 *
 * @author Saju
 *
 */

public class Main {

    private static int dx[] = { 1, 0, -1, 0 };
    private static int dy[] = { 0, -1, 0, 1 };

    private static final long INF = (long) Math.pow(10, 16);
    private static final int INT_INF = Integer.MAX_VALUE;
    private static final long NEG_INF = Long.MIN_VALUE;
    private static final int NEG_INT_INF = Integer.MIN_VALUE;
    private static final double EPSILON = 1e-10;

    private static final long MAX = (long) 1e12;
    
    private static final long MOD = 1000000007;

    private static final int MAXN = 300005;
    private static final int MAXA = 1000007;
    private static final int MAXLOG = 22;
    private static final double PI = Math.acos(-1);
    
	public static void main(String[] args) throws IOException {

		InputReader in = new InputReader(System.in);
//		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

//         InputReader in = new InputReader(new FileInputStream("src/test.in"));
//         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/test.out")));

		
		
/*

https://codeforces.com/gym/102694/problem/C

15
1 2
1 3
2 4
2 5
4 8
4 9
3 6
3 7
6 10
6 11
7 15
10 12
10 13
11 14



*/		
		
		
		int n = in.nextInt();
		
		List<Edge> adj[] = new ArrayList[n];
		for(int i = 0; i < n; i++){
			adj[i] = new ArrayList<Edge>();
		}
		for(int i = 0; i < n - 1; i++){
			int u = in.nextInt();
			int v = in.nextInt();
			u--;
			v--;
			adj[u].add(new Edge(u, v, i));
			adj[v].add(new Edge(v, u, i));
		}
		
		int[][] pp = new int[n][22];
		long[][] cost = new long[n][22];
		
		int log2n = log(n, 2) + 1;
		
		int parent[] = new int[n];
		int level[] = new int[n];
		Arrays.fill(parent, -1);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];
		int root = 0;
		queue.add(root);
		visited[root] = true;
		
		while(!queue.isEmpty()){
			int u = queue.remove();
			for(Edge e : adj[u]){
				if(!visited[e.v]){
					visited[e.v] = true;
					queue.add(e.v);
					parent[e.v] = u;
					level[e.v] = level[u] + 1;
					cost[e.v][0] = e.cost;
				}
			}
		}
		
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
		int query = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < query; i++){
			int u = in.nextInt();
			int v = in.nextInt();
			int c = in.nextInt();
			
			u--;
			v--;
			
			int lca = getLCA(n, u, v, parent, level, pp);
			int total = 0;
			if(lca == root) {
				total = level[u] + level[v];
			}
			else {
				total = level[u] + level[v] - (2 * level[lca]);
			}
//			System.out.println(total);
			if(total <= c) {
				sb.append((v + 1) + "\n");
			}
			else if(c == level[u] - level[lca]) {
				sb.append((lca + 1) + "\n");
			}
			else if(c < level[u] - level[lca]) {
				int vv = kthancestor(u, c, log2n, pp);
//				System.out.println(vv + 1);
				sb.append((vv + 1) + "\n");
			}
			else {
				int kk = level[u] + level[v] - (2 * level[lca]) - c;
//				System.out.println(kk);
				int vv = kthancestor(v, kk, log2n, pp);
//				System.out.println(vv + 1);
				sb.append((vv + 1) + "\n");
			}
//			System.out.println("Here");
		}
		
		out.println(sb.toString());
		
		
		in.close();
		out.flush();
		out.close();
		System.exit(0);
	}

	private static int kthancestor(int u, int k, int height, int[][] pp) {

		for (int i = 0; i <= height; i++) {
			if ((k & (1 << i)) != 0) {
				u = pp[u][i];
				if (u == -1)
					break;
			}
		}
		return u;
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
	
	private static class Edge implements Comparable<Edge>{
		int u;
		int v;
		int cost;
		
		Edge(int u, int v, int cost){
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			
			return this.cost - o.cost;
		}
	}
	
	/*
	 * return the number of elements in list that are less than or equal to the val
	 */
	private static long upperBound(List<Long> list, long val) {
		int start = 0;
		int len = list.size();
		int end = len - 1;
		int mid = 0;

		while (true) {
			if (start > end) {
				break;
			}
			mid = (start + end) / 2;
			long v = list.get(mid);
			if (v == val) {
				start = mid;
				while(start < end) {
					mid = (start + end) / 2;
					if(list.get(mid) == val) {
						if(mid + 1 < len && list.get(mid + 1) == val) {
							start = mid + 1;
						}
						else {
							return mid + 1;
						}
					}
					else {
						end = mid - 1;
					}
				}
				return start + 1;
			}
			if (v > val) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (list.get(mid) < val) {
			return mid + 1;
		}
		return mid;
	}


	private static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		String str1 = sb.reverse().toString();
		return str.equals(str1);
	}

	private static String getBinaryStr(long n, int j) {
		String str = Long.toBinaryString(n);
		int k = str.length();
		for (int i = 1; i <= j - k; i++) {
			str = "0" + str;
		}

		return str;
	}
	
	private static long modInverse(long r) {
		return bigMod(r, MOD - 2, MOD);
	}
	
	private static long bigMod(long n, long k, long m) {

        long ans = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans = (ans * n) % m;
            }
            n = (n * n) % m;
            k >>= 1;
        }
        return ans;
    }
    
	private static long ceil(long n, long x) {
		long div = n / x;
        if(div * x != n) {
            div++;
        }
        return div;
	}
	
    private static int ceil(int n, int x) {
        int div = n / x;
        if(div * x != n) {
            div++;
        }
        return div;
    }

    
    private static int abs(int x) {
        if (x < 0) {
            return -x;
        }
        return x;
    }
    
    private static double abs(double x) {
        if (x < 0) {
            return -x;
        }
        return x;
    }

    private static long abs(long x) {
        if(x < 0) {
            return -x;
        }
        return x;
    }
    
    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static int log(long x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    private static int log(long x, long base) {
        return (int) (Math.log(x) / Math.log(base));
    }
    
    private static long min(long a, long b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    private static int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    private static long max(long a, long b) {
        if (a < b) {
            return b;
        }
        return a;
    }

    private static int max(int a, int b) {
        if (a < b) {
            return b;
        }
        return a;
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
        
        public int[] nextIntArr(int n) {
        	int arr[] = new int[n];
    		for(int i = 0; i < n; i++) {
    			arr[i] = nextInt();
    		}
    		return arr;
        }
        
        public long[] nextLongArr(int n) {
        	long arr[] = new long[n];
    		for(int i = 0; i < n; i++) {
    			arr[i] = nextLong();
    		}
    		return arr;
        }
        
        public int[] nextIntArr1(int n) {
        	int arr[] = new int[n + 1];
    		for(int i = 1; i <= n; i++) {
    			arr[i] = nextInt();
    		}
    		return arr;
        }
        
        public long[] nextLongArr1(int n) {
        	long arr[] = new long[n + 1];
    		for(int i = 1; i <= n; i++) {
    			arr[i] = nextLong();
    		}
    		return arr;
        }
       
        public void close() {
        	try {
        		if(reader != null) {
        			reader.close();
        		}
        	}
        	catch(Exception e) {
        		
        	}
        	
        	
        }
    }

}
