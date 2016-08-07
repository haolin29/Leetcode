class TrieNode {
    // Initialize your data structure here.
    public TrieNode() {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;
        
        TrieNode(){};
        
        TrieNode(char c) {
            this.c = c;
        };
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c,t);
            }
            
            children = t.children;
            
            if(i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return searchNode(prefix) != null && searchNode(prefix).isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
    
    public TrieNode searchNode(String s) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(!children.containsKey(c)) {
                return null;
            } 
            
            t = children.get(c);
            children = t.children;
            
        }
        
        return t;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");