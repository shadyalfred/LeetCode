public class Solution
{
    public bool IsHappy(int n)
    {
        int slow = n;
        int fast = n;
        
        do
        {
            slow = SumDigitsSquared(slow);
            fast = SumDigitsSquared(SumDigitsSquared(fast));
        } while (slow != fast);
        
        return slow == 1;
    }
    private int SumDigitsSquared(int n)
    {
        int sum = 0;
        
        while (n > 0)
        {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        
        return sum;
    }
}