public class Solution {
  private bool DidFindAllWords(Dictionary<string, int> dic)
  {
    foreach(var word in dic.Keys)
    {
      if (dic[word] > 0)
      {
        return false;
      }
    }
    return true;
  }
  public IList<int> FindSubstring(string s, string[] words) {
    Dictionary<string, int> WORDS = new Dictionary<string, int>(words.Length);
    foreach (var word in words)
    {
      WORDS[word] = WORDS.GetValueOrDefault(word, 0) + 1;
    }
    Dictionary<string, int> currentWords = new Dictionary<string, int>(WORDS);
    IList<int> result = new List<int>();
    int i = 0;
    int len = words[0].Length;
    int windowStart = 0;
    int windowEnd = len;
    while (windowEnd <= s.Length && windowStart < s.Length)
    {
      string word = s[windowStart .. windowEnd];

      if (currentWords.ContainsKey(word) && currentWords[word] > 0)
      {
        currentWords[word] -= 1;
        windowStart += len;
        windowEnd += len;
      }
      else
      {
        i++;
        windowStart = i; 
        windowEnd = windowStart + len;
        currentWords = new Dictionary<string, int>(WORDS);
      }
      
      if (DidFindAllWords(currentWords))
      {
        result.Add(i);
        i++;
        windowStart = i; 
        windowEnd = windowStart + len;
        // 0123456789
        // foobarfoobar
        // windowStart = 0 -> 3
        // windowEnd = 3 -> 6
        currentWords = new Dictionary<string, int>(WORDS);
      }

    }
    
    return result;
  }
}