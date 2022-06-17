public class Solution {
    public int MinCostClimbingStairs(int[] cost) {
        if (cost.Length == 0)
        {
            return 0;
        }
        else if (cost.Length == 1)
        {
            return 0;
        }
        
        int[] minCost = new int[cost.Length + 1];
        
        minCost[0] = 0;
        minCost[1] = 0;
        
        for (int i = 2; i <= cost.Length; i++)
        {
            minCost[i] = Math.Min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        
        return minCost[cost.Length];
    }
}