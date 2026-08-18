class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int n : target) {
            pq.offer(n);
            sum += n;
        }

        while (pq.peek() != 1) {
            int curr = pq.poll();
            if (sum - curr == 1) return true;

            long x = curr % (sum - curr);
            sum = sum - curr + x;

            if (x == 0 || x == curr) return false;
            else pq.add((int)x);
        }
        
        return true;
    }
}