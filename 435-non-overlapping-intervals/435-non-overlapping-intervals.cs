public class Solution
{
    public int EraseOverlapIntervals(int[][] intervals)
    {
        Array.Sort(
            intervals,
            Comparer<int[]>.Create((x, y) =>
                {
                    if (x[0] == y[0])
                    {
                        return x[1].CompareTo(y[1]);
                    }
                    
                    return x[0].CompareTo(y[0]);
                }
          )
        );
        
        int total = 0;
        
        int previousEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.Length; i++)
        {
            if (intervals[i][0] >= previousEnd)
            {
                previousEnd = intervals[i][1];
            }
            else
            {
                total++;
                previousEnd = Math.Min(previousEnd, intervals[i][1]);
            }
        }
        
        return total;
    }
}