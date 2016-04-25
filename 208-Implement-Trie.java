class TrieNode {
	char c;
	HashMap<Character, TrieNode> children = new HashMap<>();
	TrieNode (char c) {
		this.c = c;
	}
	boolean isLeaf;
	TrieNode() {};
}

public class Trie {
	private TrieNode root;

	public Tire() {
		root = new TrieNode(){};
	}

	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode t;
			if (!children.containsKey(c)) {
				t = new TrieNode(c);
				children.put(c,t);
			} else {
				t = children.get(c);
			}
			children = t.children;

			if (i == word.length() - 1) {
				t.isLeaf = true;
			}

		}
	}

	public boolean search(String word) {
		TrieNode t = searchNode(word);
		if (t != null && t.isLeaf) {
			return true;
		}
		return false;

	}

	public boolean startWith(String prefix) {
		TrieNode t = searchNode(prefix);
		if (t != null) {
			return true;
		}
		return false;
	}

	public TrieNode searchNode(String str) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(!children.containsKey(c)) {
				return null;
			} else {
				t = children.get(c);
			}

			children = t.children();

		}

		return t;
	}



}