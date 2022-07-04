public class Solution
{
    public int LongestConsecutive(int[] nums)
    {
        if (nums.Length == 0)
        {
            return 0;
        }
        
        var hashSet = new HashSet<int>(nums.Length);
        
        foreach (var num in nums)
        {
            hashSet.Add(num);
        }
        
        int maxSeq = 1;
        
        for (int i = 0; i < nums.Length; i++)
        {
            var num = nums[i];
            
            if (hashSet.Contains(num - 1))
            {
                continue;
            }
            
            int seqLen = 1;
            
            while (hashSet.Contains(num + 1))
            {
                num++;
                seqLen++;
            }
            
            maxSeq = Math.Max(maxSeq, seqLen);
        }
            
        return maxSeq;
    }
}