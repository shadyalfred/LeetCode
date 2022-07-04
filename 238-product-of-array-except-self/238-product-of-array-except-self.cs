public class Solution
{
    public int[] ProductExceptSelf(int[] nums)
    {
        int N = nums.Length;
        int[] prefix = new int[N];
        int[] postfix = new int[N];
        int[] answer = new int[N];
        
        for (int i = 0; i < N; i++)
        {
            if (i == 0)
            {
                prefix[i] = 1;
                postfix[N - 1] = 1;
                continue;
            }
            
            prefix[i] = prefix[i - 1] * nums[i - 1];
            postfix[N - i - 1] = postfix[N - i] * nums[N - i];
        }
        
        for (int i = 0; i < N; i++)
        {
            answer[i] = prefix[i] * postfix[i];
        }
        
        return answer;
    }
}