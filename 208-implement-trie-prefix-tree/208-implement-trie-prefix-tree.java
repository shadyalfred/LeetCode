class Trie {
    class Node {
        boolean isWord;
        Map<Character, Node> children = new HashMap();
    }

    Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        var curr = root;
        
        for (var c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        var curr = root;
        
        for (var c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        var curr = root;
        
        for (var c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */