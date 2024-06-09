class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;

        Map<Integer, Integer> prefixSumCountTable = new HashMap<>(nums.length);

        prefixSumCountTable.put(0, 1);

        int sum = 0;

        for (int num : nums) {
            sum += num;

            int diff = sum - k;

            if (prefixSumCountTable.containsKey(diff)) {
                result += prefixSumCountTable.get(diff);
            }

            prefixSumCountTable.put(sum, prefixSumCountTable.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}