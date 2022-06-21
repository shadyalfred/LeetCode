public class MapSum
{
  class Trie
  {
    class TrieNode
    {
      public Dictionary<char, TrieNode> Edges;
      public bool IsWordEnd { get; set; }
      public int Value { get; set; }
      public int PrefixSum { get; set; }

      public TrieNode()
      {
        Edges = new Dictionary<char, TrieNode>();
        IsWordEnd = false;
        Value = 0;
        PrefixSum = 0;
      }
    }

    TrieNode root;

    public Trie()
    {
      root = new TrieNode();
    }

    public void Insert(string word, int Value)
    {
      int currentValue = GetWordValue(word);
      int difference = Value - currentValue;

      TrieNode currentNode = root;
      foreach (char c in word.ToCharArray())
      {
        if (! currentNode.Edges.ContainsKey(c))
        {
          currentNode.Edges[c] = new TrieNode();
        }
        currentNode = currentNode.Edges[c];
        currentNode.PrefixSum += difference;
      }
      currentNode.IsWordEnd = true;
      currentNode.Value = Value;
    }

    public int GetWordValue(string word)
    {
      TrieNode currentNode = root;
      foreach (char c in word.ToCharArray())
      {
        if (! currentNode.Edges.ContainsKey(c))
        {
          return 0;
        }
        currentNode = currentNode.Edges[c];
      }
      return currentNode.Value;
    }

    public int GetPrefixSum(string prefix)
    {
      TrieNode currentNode = root;
      foreach (char c in prefix.ToCharArray())
      {
        if (! currentNode.Edges.ContainsKey(c))
        {
          return 0;
        }
        currentNode = currentNode.Edges[c];
      }
      return currentNode.PrefixSum;
    }
  }

  Trie trie;
  

  public MapSum() {
    trie = new Trie();
  }

  public void Insert(string key, int val) {
    trie.Insert(key, val);
  }

  public int Sum(string prefix) {
    return trie.GetPrefixSum(prefix);
  }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.Insert(key,val);
 * int param_2 = obj.Sum(prefix);
 */