public class Solution
{
    private int N = 0;
    private int[] nums;
    
    public bool CircularArrayLoop(int[] nums)
    {
        this.N = nums.Length;
        this.nums = nums;
        int slow = 0, fast = 0;
        
        for (int i = 0; i < nums.Length; i++)
        {
            bool isForward = nums[i] >= 0;
            
            slow = i;
            fast = i;
            
            do
            {
                slow = GetNextIndex(slow, isForward);
                fast = GetNextIndex(fast, isForward);
                if (fast != -1)
                {
                    fast = GetNextIndex(fast, isForward);
                }
            } while (slow != -1 && fast != -1 && fast != slow);
            

            if (slow != -1 && slow == fast)
            {
                return true;
            }
        }
        
        return false;
    }
    
    private int GetNextIndex(int i, bool isForward)
    {
        if ((nums[i] >= 0) != isForward)
        {
            return -1;
        }
        
        int nextI = (i + nums[i]) % N;
        if (nextI < 0)
        {
            nextI += N;
        }
        
        if (nextI == i)
        {
            return -1;
        }
        
        return nextI;
    }
}