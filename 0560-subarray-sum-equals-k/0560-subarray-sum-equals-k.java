class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;

        Map<Integer, Integer> prefixCountTable = new HashMap<>(nums.length);

        prefixCountTable.put(0, 1);

        int sum = 0;

        for (int num : nums) {
            sum += num;

            int diff = sum - k;

            if (prefixCountTable.containsKey(diff)) {
                result += prefixCountTable.get(diff);
            }

            prefixCountTable.put(sum, prefixCountTable.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}