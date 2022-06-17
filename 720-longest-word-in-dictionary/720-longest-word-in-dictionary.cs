public class Solution {
    class Trie
    {
        class TrieNode
        {
            public Dictionary<char, TrieNode> edges = new Dictionary<char, TrieNode>();
            public bool isWordEnd;
        }
        
        private TrieNode root = new TrieNode();
        
        public void Insert(string word)
        {
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
        public bool CanBeBuilt(string word)
        {
            TrieNode currentNode = root;
            foreach (char c in word)
            {
                if (! currentNode.edges.ContainsKey(c))
                {
                    return false;
                }
                currentNode = currentNode.edges[c];
                if (! currentNode.isWordEnd)
                {
                    return false;
                }
            }
            return true;
        }
    }
    public string LongestWord(string[] words) {
        Trie trie = new Trie();
        foreach (string word in words)
        {
            trie.Insert(word);
        }
        
        string answer = null;
        
        for (int i = 0; i < words.Length; i++)
        {
            if (trie.CanBeBuilt(words[i]))
            {
                if (answer is null)
                {
                    answer = words[i];
                    continue;
                }
                if (words[i].Length > answer.Length)
                {
                    answer = words[i];
                }
                else if (words[i].Length == answer.Length)
                {
                    if (string.Compare(answer, words[i]) > 0)
                    {
                        answer = words[i];
                    }
                }
            }
        }
        
        return answer ?? "";
    }
}