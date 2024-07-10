class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            for (int i = 0; i < k; i++) {
                int player = q.poll();

                if (i + 1 != k) {
                    q.offer(player);
                }
            }
        }

        return q.poll();
    }
}