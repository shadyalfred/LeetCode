public class Solution
{
    public int[][] Merge(int[][] intervals)
    {
        Array.Sort(intervals, new Comparison<int[]>(
            (x, y) => { return x[0].CompareTo(y[0]); }
        ));
        
        IList<int[]> mergedIntervals = new List<int[]>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.Length; i++)
        {
            int[] interval = intervals[i];
            
            if (interval[0] <= end)
            {
                end = Math.Max(end, interval[1]);
            }
            else
            {
                mergedIntervals.Add(new int[] { start, end });
                start = interval[0];
                end = interval[1];
            }
        }
        
        mergedIntervals.Add(new int[] { start, end });
        
        return mergedIntervals.ToArray();
    }
}