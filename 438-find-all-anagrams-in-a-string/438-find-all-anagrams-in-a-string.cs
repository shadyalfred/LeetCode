public class Solution
{
    public IList<int> FindAnagrams(string s, string p)
    {
        IList<int> answer = new List<int>();
        
        var freq = new Dictionary<char, int>();
        foreach (char c in p)
        {
            freq[c] = freq.GetValueOrDefault(c, 0) + 1;
        }
        
        int l = 0;
        int matches = 0;
        for (int r = 0; r < s.Length; r++)
        {
            char rightChar = s[r];
            if (freq.ContainsKey(rightChar))
            {
                freq[rightChar]--;
                if (freq[rightChar] == 0)
                {
                    matches++;
                }
            }
            
            if (matches == freq.Keys.Count)
            {
                answer.Add(l);
            }
                
            if (r >= p.Length - 1)
            {
                char leftChar = s[l];
                if (freq.ContainsKey(leftChar))
                {
                    if (freq[leftChar] == 0)
                    {
                        matches--;
                    }
                    freq[leftChar]++;
                }
                l++;
            }
            
            
        }
        return answer;
    }
}