class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue();
    
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for (var num : nums) add(num);
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */