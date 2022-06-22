public class Solution
{
    public bool CheckInclusion(string s1, string s2)
    {
        var freq = new Dictionary<char, int>();
        
        foreach (char c in s1)
        {
            freq[c] = freq.GetValueOrDefault(c, 0) + 1;
        }

        int l = 0;
        
        int matches = 0;

        for (int r = 0; r < s2.Length; r++)
        {
            char rightChar = s2[r];
            if (freq.ContainsKey(rightChar))
            {
                freq[rightChar]--;
                if (freq[rightChar] == 0)
                {
                    matches++;
                }
            }
            
            if (r - l + 1 > s1.Length)
            {
                char leftChar = s2[l];
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
            
            if (matches == freq.Keys.Count)
            {
                return true;
            }
            
        }

        return false;
    }
}