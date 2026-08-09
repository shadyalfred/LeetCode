class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> indexOf = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            indexOf.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                result[indexOf.get(stack.pop())] = nums2[i];
            }

            if (indexOf.containsKey(nums2[i])) {
                stack.push(nums2[i]);
            }
        }
        
        return result;
    }
}