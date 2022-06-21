using System;
using System.Collections;
using System.Collections.Generic;

namespace lintcode
{
    class Solution
    {
        /**
         * @param s: A string
         * @param k: An integer
         * @return: An integer
         */
        public int LengthOfLongestSubstringKDistinct(string s, int k)
        {
            int answer = 0;

            if (s.Length == 0 || k == 0)
            {
                return answer;
            }

            if (s.Length < k)
            {
                return s.Length;
            }

            Dictionary<char, int> count = new Dictionary<char, int>();
            int l = 0;
            for (int r = 0; r < s.Length; r++)
            {
                char c = s[r];
                count[c] = count.GetValueOrDefault(c, 0) + 1;
                if (count.Keys.Count <= k)
                {
                    answer = Math.Max(answer, r - l + 1);
                    continue;
                }
                while (count.Keys.Count > k)
                {
                    count[s[l]]--;
                    if (count[s[l]] == 0)
                    {
                        count.Remove(s[l]);
                    }
                    l++;
                }
            }
            return answer;
        }
    }
}
