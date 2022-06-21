public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        if (s.Length == 0)
        {
            return 0;
        }
        
        int answer = 1;
        
        Dictionary<char, int> count = new Dictionary<char, int>();
        
        int l = 0;
        for (int r = 0; r < s.Length; r++)
        {
            count[s[r]] = count.GetValueOrDefault(s[r], 0) + 1;
            if (count[s[r]] > 1)
            {
                while (count[s[r]] > 1)
                {
                    count[s[l]]--;
                    if (count[s[l]] == 0)
                    {
                        count.Remove(s[l]);
                    }
                    l++;
                }
            }
            else
            {
                answer = Math.Max(answer, r - l + 1);
            }
        }
        return answer;
    }
}