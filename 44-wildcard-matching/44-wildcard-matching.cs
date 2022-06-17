public class Solution {
    public bool IsMatch(string str, string pattern)
    {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.Length)
        {
            if (p < pattern.Length && (pattern[p] == '?' || str[s] == pattern[p]))
            {
                s++;
                p++;
            }
            else if (p < pattern.Length && pattern[p] == '*')
            {
                starIdx = p;
                match = s;
                p++;
            }
            else if (starIdx != -1)
            {
                p = starIdx + 1;
                match++;
                s = match;
            }
            else return false;
        }

        while (p < pattern.Length && pattern[p] == '*')
            p++;

        return p == pattern.Length;
    }

}