public class Solution
{
    public int CharacterReplacement(string s, int k)
    {
        var count = new Dictionary<char, int>();
        
        int answer = 0;
        int maxRepeatingChar = 0;
        
        int l = 0;
        for (int r = 0; r < s.Length; r++)
        {
            count[s[r]] = count.GetValueOrDefault(s[r], 0) + 1;
            maxRepeatingChar = Math.Max(maxRepeatingChar, count[s[r]]);
            if (r - l + 1 - maxRepeatingChar > k)
            {
                count[s[l]]--;
                l++;
            }
            
            answer = Math.Max(answer, r - l + 1);
        }
        return answer;
    }
}