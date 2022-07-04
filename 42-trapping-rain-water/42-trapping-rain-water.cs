public class Solution
{
    public int Trap(int[] height)
    {
        if (height.Length == 0)
        {
            return 0;
        }
        
        int l = 0, r = height.Length - 1;
        
        int totalWater = 0,
            maxLeft = height[l],
            maxRight = height[r];
        
        while (l < r)
        {
            if (maxLeft < maxRight)
            {
                int temp = maxLeft - height[l];
                if (temp > 0)
                {
                    totalWater += temp;
                }
                l++;
                maxLeft = Math.Max(maxLeft, height[l]);
            }
            else
            {
                int temp = maxRight - height[r];
                if (temp > 0)
                {
                    totalWater += temp;
                }
                r--;
                maxRight = Math.Max(maxRight, height[r]);
            }
        }
        return totalWater;
    }
}