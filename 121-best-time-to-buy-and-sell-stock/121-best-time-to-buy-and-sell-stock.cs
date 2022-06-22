public class Solution
{
    public int MaxProfit(int[] prices)
    {
        int maxProfit = 0;
        int l = 0;
        for (int r = 0; r < prices.Length; r++)
        {
            if (prices[r] < prices[l])
            {
                l = r;
                continue;
            }
            
            maxProfit = Math.Max(prices[r] - prices[l], maxProfit);
        }
        return maxProfit;
    }
}