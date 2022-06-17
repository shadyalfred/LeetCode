public class Trie {
    class TrieNode
    {
        public Dictionary<char, TrieNode> edges = new Dictionary<char, TrieNode>();
        public bool isWordEnd;
        
        public TrieNode()
        {
        }
    }
    
    private TrieNode root = new TrieNode();
    public Trie()
    {
    }
    
    public void Insert(string word) {
        TrieNode currentNode = root;
        foreach (char c in word)
        {
            if (! currentNode.edges.ContainsKey(c))
            {
                currentNode.edges[c] = new TrieNode();
            }
            currentNode = currentNode.edges[c];
        }
        currentNode.isWordEnd = true;
    }
    
    public bool Search(string word)
    {
        TrieNode currentNode = root;
        
        foreach (char c in word)
        {
            if (! currentNode.edges.ContainsKey(c))
            {
                return false;
            }
            currentNode = currentNode.edges[c];
        }
        
        return currentNode.isWordEnd;
        
    }
    
    public bool StartsWith(string prefix)
    {
        TrieNode currentNode = root;
        
        foreach (char c in prefix)
        {
            if (! currentNode.edges.ContainsKey(c))
            {
                return false;
            }
            currentNode = currentNode.edges[c];
        }
        
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */