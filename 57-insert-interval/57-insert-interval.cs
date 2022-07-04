public class Solution
{
    public int[][] Insert(int[][] intervals, int[] newInterval)
    {
        if (intervals.Length == 0)
        {
            return new int[][] { newInterval };
        }
        
        List<int[]> mergedIntervals = new List<int[]>(intervals.Length);
        
        int i = 0;
        
        while (i < intervals.Length && intervals[i][1] < newInterval[0])
        {
            mergedIntervals.Add(intervals[i++]);
        }
        
        while (i < intervals.Length && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.Min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.Max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        mergedIntervals.Add(newInterval);
        
        while (i < intervals.Length)
        {
            mergedIntervals.Add(intervals[i++]);
        }
        
        return mergedIntervals.ToArray();
    }
}