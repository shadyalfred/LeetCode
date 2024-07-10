class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < k; i++) {
                int player = deque.pollFirst();
                deque.offerLast(player);
            }

            deque.pollLast();
        }

        return deque.poll();
    }
}