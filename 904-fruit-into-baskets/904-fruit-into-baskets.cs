public class Solution
{
    public int TotalFruit(int[] fruits)
    {
        Dictionary<int, int> count = new Dictionary<int, int>();
        
        int answer = 0;
        
        int l = 0;
        for (int r = 0; r < fruits.Length; r++)
        {
            count[fruits[r]] = count.GetValueOrDefault(fruits[r], 0) + 1;
            if (count.Keys.Count <= 2)
            {
                answer = Math.Max(answer, r - l + 1);
            }
            else
            {
                while (count.Keys.Count > 2)
                {
                    count[fruits[l]]--;
                    if (count[fruits[l]] == 0)
                    {
                        count.Remove(fruits[l]);
                    }
                    l++;
                }
            }
        }
        return answer;
    }
}