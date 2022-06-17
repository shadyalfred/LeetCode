public class Solution {
    public int LengthOfLIS(int[] nums) {
        if (nums.Length == 0)
        {
            return 0;
        }
        
        int[] lengths = new int[nums.Length];
        
        for (int i = 0; i < lengths.Length; i++)
        {
            lengths[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i])
                { 
                    lengths[i] = Math.Max(lengths[i], 1 + lengths[j]);
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < lengths.Length; i++)
        {
            answer = Math.Max(answer, lengths[i]);
        }
        
        return answer;
    }
}