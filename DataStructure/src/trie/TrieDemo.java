package trie;
import java.util.*;

public class TrieDemo {

	public static void main(String[] args) {

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

}
