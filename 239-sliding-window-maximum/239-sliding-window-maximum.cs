public class Solution
{
    public int[] MaxSlidingWindow(int[] nums, int k)
    {
        int[] maximumValues = new int[nums.Length - k + 1];
        
        // monotonically decreasing queue
        var indeciesOfMaxValues = new LinkedList<int>();
        
        int l = 0;
        for (int r = 0; r < nums.Length; r++)
        {
            while (indeciesOfMaxValues.Count > 0 &&
                   nums[r] > nums[indeciesOfMaxValues.Last.Value])
            {
                indeciesOfMaxValues.RemoveLast();
            }
            
            indeciesOfMaxValues.AddLast(r);
            
            if (r - l + 1 == k)
            {
                maximumValues[l] = nums[indeciesOfMaxValues.First.Value];
                
                if (indeciesOfMaxValues.Count > 0 &&
                    l == indeciesOfMaxValues.First.Value)
                {
                    indeciesOfMaxValues.RemoveFirst();
                }
                    
                l++;
            }
        }
        
        return maximumValues;
    }
}