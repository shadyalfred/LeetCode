public class Solution
{
    public int MaxArea(int[] height)
    {
        int maxArea = 0;
        
        int l = 0, r = height.Length - 1;
        
        while (l < r)
        {
            int area = Math.Min(height[r], height[l]) * (r - l);
            
            maxArea = Math.Max(maxArea, area);
            
            if (height[r] >= height[l])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        
        return maxArea;
    }
}