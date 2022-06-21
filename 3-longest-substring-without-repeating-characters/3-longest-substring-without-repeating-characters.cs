public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        if (s.Length == 0)
        {
            return 0;
        }
        
        int answer = 1;
        
        Dictionary<char, int> charToIndexMap = new Dictionary<char, int>();
        
        int l = 0;
        for (int r = 0; r < s.Length; r++)
        {
            if (charToIndexMap.ContainsKey(s[r]))
            {
                l = Math.Max(l, charToIndexMap[s[r]] + 1);
            }
            
            answer = Math.Max(answer, r - l + 1);
            charToIndexMap[s[r]] = r;
        }
        return answer;
    }
}