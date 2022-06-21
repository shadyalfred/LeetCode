public class Solution
{
  public bool IsAnagram(string s, string t)
  {
    if (s.Length != t.Length)
    {
      return false;
    }
    
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];
    
    for (int i = 0; i < s.Length; i++)
    {
      freq1[s[i] - 'a']++;
      freq2[t[i] - 'a']++;
    }
    
    for (int i = 0; i < 26; i++)
    {
      if (freq1[i] != freq2[i])
        return false;
    }
    
    return true;
  }
}