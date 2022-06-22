public class Solution
{
    public bool CheckInclusion(string s1, string s2)
    {
        var targetCount = new Dictionary<char, int>();
        foreach (char c in s1)
        {
            targetCount[c] = targetCount.GetValueOrDefault(c, 0) + 1;
        }
        
        int l = 0;
        var currentCount = new Dictionary<char, int>();
        
        //"adc"
        //"dcda" 
        for(int r = 0; r < s2.Length; r++)
        {
            currentCount[s2[r]] = currentCount.GetValueOrDefault(s2[r], 0) + 1;
            
            int len = r - l + 1;
            
            if (len > s1.Length || currentCount[s2[r]] > targetCount.GetValueOrDefault(s2[r], 0))
            {
                currentCount[s2[l]]--;
                if (currentCount[s2[l]] == 0)
                {
                    currentCount.Remove(s2[l]);
                }
                l++;
            }
            
            
            if (r - l + 1 == s1.Length)
            {
                if (AreEqual(currentCount, targetCount))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private bool AreEqual(Dictionary<char, int> dic1, Dictionary<char, int> dic2)
    {
        if (dic1.Keys.Count != dic2.Keys.Count)
        {
            return false;
        }
        
        foreach (var key in dic1.Keys)
        {
            if (! dic2.ContainsKey(key))
            {
                return false;
            }
            
            if (dic1[key] != dic2[key])
            {
                return false;
            }
        }
        
        return true;
    }
}