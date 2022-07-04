public class Solution
{
    public int[] TopKFrequent(int[] nums, int k)
    {
        var q = new PriorityQueue<int, int>(
            nums.Length,
            Comparer<int>.Create((x, y) => y.CompareTo(x))
        );
        
        var freq = new Dictionary<int, int>();
        
        foreach (var num in nums)
        {
            freq[num] = freq.GetValueOrDefault(num, 0) + 1;
        }
        
        foreach (var key in freq.Keys)
        {
            q.Enqueue(key, freq[key]);
        }
        
        var topNums = new int[k];
        
        while (k > 0)
        {
            topNums[topNums.Length - k] = q.Dequeue();
            k--;
        }
        
        return topNums;
    }
}