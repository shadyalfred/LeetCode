class Solution {
    public int findKthLargest(int[] nums, int k) {
        var maxHeap = new PriorityQueue<Integer>(nums.length,
            (num1, num2) -> num2.compareTo(num1)
        );
        
        maxHeap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        
        while (k > 1) {
            maxHeap.poll();
            k--;
        }
        
        return maxHeap.poll();
    }
}