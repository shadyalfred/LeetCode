public class Solution
{
    public string MinWindow(string s, string t)
    {
        var freq = new Dictionary<char, int>();
        
        foreach (char c in t)
        {
            freq[c] = freq.GetValueOrDefault(c, 0) + 1;
        }
        
        int l = 0;
        int matched = 0;
        int minLength = s.Length + 1;
        int subStrStart = 0;
            
        for (int r = 0; r < s.Length; r++)
        {
            char rightChar = s[r];
            if (freq.ContainsKey(rightChar))
            {
                freq[rightChar]--;
                if (freq[rightChar] >= 0)
                    matched++;
            }
            
            while (matched == t.Length)
            {
                if (r - l + 1 < minLength)
                {
                    minLength = r - l + 1;
                    subStrStart = l;
                }
                
                char leftChar = s[l];
                if (freq.ContainsKey(leftChar))
                {
                    if (freq[leftChar] == 0)
                    {
                        matched--;
                    }
                    freq[leftChar]++;
                }
                
                l++;
            }
                
        }
        
        return minLength > s.Length ? "" : s.Substring(subStrStart, minLength);
    }
}