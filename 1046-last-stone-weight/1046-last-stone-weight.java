class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (var stone : stones) maxHeap.offer(stone);
        
        int result = 0;
        
        while (maxHeap.size() > 1) {
            var first = maxHeap.poll();
            var second = maxHeap.poll();
            
            maxHeap.offer(first - second);
        }
        
        return maxHeap.poll();
    }
}