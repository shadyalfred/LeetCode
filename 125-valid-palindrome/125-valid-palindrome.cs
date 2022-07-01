public class Solution
{
    public bool IsPalindrome(string s)
    {
        int l = 0, r = s.Length - 1;
        
        while (l < r)
        {
            while (
                ! (
                    char.IsLetter(s[l]) ||
                    char.IsDigit(s[l])
                ) &&
                (l < r)
            )
            {
                l++;
            }
            
            while (
                ! (
                    char.IsLetter(s[r]) ||
                    char.IsDigit(s[r])
                ) &&
                (l < r)
            )
            {
                r--;
            }
            
            if (char.ToLower(s[l]) != char.ToLower(s[r]))
            {
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
}