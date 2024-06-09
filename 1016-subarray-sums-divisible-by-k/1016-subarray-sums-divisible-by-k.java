class Solution {
    // One increasing window from left to right.
    // If we can remove from its left side a window
    // which makes it divisible by K, then we have found
    // a solution.
    // Construct a table which has the count of the remainders of
    // the window’s sum when divided by k.
    // | Remainder | Count |
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;

        Map<Integer, Integer> prefixRemCountMap = new HashMap<>(1);

        prefixRemCountMap.put(0, 1);

        int sum = 0;

        for (int num : nums) {
            sum += num;

            int rem = sum % k;

            // mimic python’s modulo operator behavio
            // in python -1 % 5 = 4
            // in java -1 % 5 = -1
            // Python only gives a negative answer
            // if the denominator of the module operation
            // is negative.
            if (sum < 0 && rem != 0) { 
                rem += k;
            }

            if (prefixRemCountMap.containsKey(rem)) {
                result += prefixRemCountMap.get(rem);
            }

            prefixRemCountMap.put(rem, prefixRemCountMap.getOrDefault(rem, 0) + 1);
        }

        return result;
    }
}