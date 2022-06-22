public class Solution
{
    public int LongestOnes(int[] nums, int k)
    {
        int answer = 0;
        
        int countOnes = 0;
        
        int l = 0;
        for(int r = 0; r < nums.Length; r++)
        {
            if (nums[r] == 1)
            {
                countOnes++;
            }
            
            if (r - l + 1 - countOnes > k)
            {
                if (nums[l] == 1)
                {
                    countOnes--;
                }
                l++;
            }
            
            answer = Math.Max(answer, r - l + 1);
        }
        return answer;
        
    }
}