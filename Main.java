import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Saju
 *
 */

public class Main {

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

/*



*/
		
		
		
		
		out.flush();
		out.close();
		System.exit(0);
	}
	
	private static void testTrie(){
		Trie trie = new Trie();
		 
	    trie.insert("Programming");
	    trie.insert("is");
	    trie.insert("a");
	    trie.insert("way");
	    trie.insert("of");
	    trie.insert("life");
	    
	    
	    System.out.println(trie.containsNode("is"));
	    trie.delete("is");
	    System.out.println(trie.containsNode("is"));
	}

	
	private static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		void insert(String word) {
			TrieNode current = root;

			for (int i = 0; i < word.length(); i++) {
				current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			current.setEndOfWord(true);
		}

		boolean delete(String word) {
			return delete(root, word, 0);
		}

		boolean containsNode(String word) {
			TrieNode current = root;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				TrieNode node = current.getChildren().get(ch);
				if (node == null) {
					return false;
				}
				current = node;
			}
			return current.isEndOfWord();
		}

		boolean isEmpty() {
			return root == null;
		}

		private boolean delete(TrieNode current, String word, int index) {
			if (index == word.length()) {
				if (!current.isEndOfWord()) {
					return false;
				}
				current.setEndOfWord(false);
				return current.getChildren().isEmpty();
			}
			char ch = word.charAt(index);
			TrieNode node = current.getChildren().get(ch);
			if (node == null) {
				return false;
			}
			boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

			if (shouldDeleteCurrentNode) {
				current.getChildren().remove(ch);
				return current.getChildren().isEmpty();
			}
			return false;
		}
	}

	private static class TrieNode {
		private final Map<Character, TrieNode> children = new HashMap<>();
		private boolean endOfWord;

		Map<Character, TrieNode> getChildren() {
			return children;
		}

		boolean isEndOfWord() {
			return endOfWord;
		}

		void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
	}
	
	private static int maxMatch(int n, int m, List<Integer>[] list) {
        int matching[] = new int[m + 1];
        boolean visited[] = new boolean[n + 1];
       
        Arrays.fill(matching, -1);
        int match  = 0;
        for(int i = 0; i < n; i++){
        	
            Arrays.fill(visited, false);
            if(hasPath(i, n, m, list, visited, matching)){
                match++;
            }
           
        }
        return match;
    }
 
    private static boolean hasPath(int i, int n, int m, List<Integer>[] list, boolean[] visited, int[] matching) {
        visited[i] = true;
       
        for(int v : list[i]){
            int j = matching[v];
            if(j == -1 || (!visited[j] && hasPath(j, n, m, list, visited, matching))){
                matching[v] = i;
                return true;
            }
        }
       
        return false;
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
	
	private class TrieTusar {

	    private class TrieNode {
	        Map<Character, TrieNode> children;
	        boolean endOfWord;
	        public TrieNode() {
	            children = new HashMap<>();
	            endOfWord = false;
	        }
	    }

	    private final TrieNode root;
	    public TrieTusar() {
	        root = new TrieNode();
	    }
	    
	    public void test(String[] args){
	    	
	    
	    	TrieTusar ttr = new TrieTusar();
	    	ttr.insert("baggers");
	    	ttr.insert("beggars");
	    	ttr.insert("in");
	    	ttr.insert("the");
	    	ttr.insert("blowed");
	    	ttr.insert("bowled");
	    	ttr.insert("barn");
	    	ttr.insert("bran");

	    	
	    }

	    /**
	     * Iterative implementation of insert into trie
	     */
	    public void insert(String word) {
	        TrieNode current = root;
	        for (int i = 0; i < word.length(); i++) {
	            char ch = word.charAt(i);
	            TrieNode node = current.children.get(ch);
	            if (node == null) {
	                node = new TrieNode();
	                current.children.put(ch, node);
	            }
	           
	            current = node;
	          
	        }
	       
	        //mark the current nodes endOfWord as true
	        current.endOfWord = true;
	    }

	    /**
	     * Recursive implementation of insert into trie
	     */
	    public void insertRecursive(String word) {
	        insertRecursive(root, word, 0);
	    }


	    private void insertRecursive(TrieNode current, String word, int index) {
	        if (index == word.length()) {
	            //if end of word is reached then mark endOfWord as true on current node
	            current.endOfWord = true;
	            return;
	        }
	        char ch = word.charAt(index);
	        TrieNode node = current.children.get(ch);

	        //if node does not exists in map then create one and put it into map
	        if (node == null) {
	            node = new TrieNode();
	            current.children.put(ch, node);
	        }
	        insertRecursive(node, word, index + 1);
	    }

	    /**
	     * Iterative implementation of search into trie.
	     */
	    public boolean search(String word) {
	        TrieNode current = root;
	        for (int i = 0; i < word.length(); i++) {
	            char ch = word.charAt(i);
	            TrieNode node = current.children.get(ch);
	            //if node does not exist for given char then return false
	            if (node == null) {
	                return false;
	            }
	            current = node;
	        }
	        //return true of current's endOfWord is true else return false.
	        return current.endOfWord;
	    }

	    /**
	     * Recursive implementation of search into trie.
	     */
	    public boolean searchRecursive(String word) {
	        return searchRecursive(root, word, 0);
	    }
	    private boolean searchRecursive(TrieNode current, String word, int index) {
	        if (index == word.length()) {
	            //return true of current's endOfWord is true else return false.
	            return current.endOfWord;
	        }
	        char ch = word.charAt(index);
	        TrieNode node = current.children.get(ch);
	        //if node does not exist for given char then return false
	        if (node == null) {
	            return false;
	        }
	        return searchRecursive(node, word, index + 1);
	    }

	    /**
	     * Delete word from trie.
	     */
	    public void delete(String word) {
	        delete(root, word, 0);
	    }

	    /**
	     * Returns true if parent should delete the mapping
	     */
	    private boolean delete(TrieNode current, String word, int index) {
	        if (index == word.length()) {
	            //when end of word is reached only delete if currrent.endOfWord is true.
	            if (!current.endOfWord) {
	                return false;
	            }
	            current.endOfWord = false;
	            //if current has no other mapping then return true
	            return current.children.size() == 0;
	        }
	        char ch = word.charAt(index);
	        TrieNode node = current.children.get(ch);
	        if (node == null) {
	            return false;
	        }
	        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

	        //if true is returned then delete the mapping of character and trienode reference from map.
	        if (shouldDeleteCurrentNode) {
	            current.children.remove(ch);
	            //return true if no mappings are left in the map.
	            return current.children.size() == 0;
	        }
	        return false;
	    }
	    
	    
	}
}
