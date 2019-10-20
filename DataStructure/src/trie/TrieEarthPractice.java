package trie;

import java.util.*;
import java.lang.*;
import java.io.*;


public class TrieEarthPractice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		for(int i = 0; i < n; i++){
			String str = sc.next();
			int weight = sc.nextInt();
			
			int len = str.length();
			StringBuilder sb = new StringBuilder();
			
			for(int j = 0; j < len; j++){
				sb.append(String.valueOf(str.charAt(j)));
				
				if(map.containsKey(sb.toString())){
					int w = map.get(sb.toString());
					if(w < weight){
						map.put(sb.toString(), weight);
					}
				}
				else{
					map.put(sb.toString(), weight);
				}
			}
			
		}
		
		for(int i = 0; i < q; i++){
			String query = sc.next();
			if(map.containsKey(query)){
				System.out.println(map.get(query));
			}
			else{
				System.out.println("-1");
			}
		}
		
//
//		NodeP trie = new NodeP();
//		
//		int n = sc.nextInt();
//		int q = sc.nextInt();
//		while (n-- > 0) {
//			String value = sc.next();
//			int p = sc.nextInt();
//			trie.insert(trie, value, p);
//		}
//
//		while (q-- > 0) {
//			String value = sc.next();
//			NodeP currentNode = trie;
//			for (char c : value.toCharArray()) {
//				// Maintain a reference to the Node matching the char for that
//				// level
//				currentNode = currentNode.children[c - 'a'];
//
//				if (currentNode == null) {
//					break;
//				}
//
//			}
//
//			// Print the number of results
//			System.out.println((currentNode != null) ? currentNode.prior : -1);
//		}

		sc.close();

	}
	private static class NodeP {
		
		int count;
		NodeP[] children;
		int prior;

		NodeP() {
			this.count = 0;
			this.children = new NodeP[26];
			this.prior = 0;
			Arrays.fill(children, null);
		}

		public void insert(NodeP current, String value, int p) {

			for (char c : value.toCharArray()) {
				int index = c - 'a';

				if (current.children[index] == null) {
					current.children[index] = new NodeP();
				}

				current.children[index].count++;
				if (current.children[index].prior < p) {
					current.children[index].prior = p;
				}

				current = current.children[index];
			}
		}
	}

	
}