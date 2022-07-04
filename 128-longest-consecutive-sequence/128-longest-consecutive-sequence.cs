public class Solution
{
    public int LongestConsecutive(int[] nums)
    {
        var numSet = new HashSet<int>(nums);
        
        int maxSeq = 0;
        
        for (int i = 0; i < nums.Length; i++)
        {
            var num = nums[i];
            
            if (numSet.Contains(num - 1))
            {
                continue;
            }
            
            int seqLen = 1;
            
            while (numSet.Contains(num + 1))
            {
                num++;
                seqLen++;
            }
            
            maxSeq = Math.Max(maxSeq, seqLen);
        }
            
        return maxSeq;
    }
}