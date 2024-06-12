class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> adj = new ArrayList<>(bombs.length);
        for (int i = 0; i < bombs.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < bombs.length; i++) {
            int[] bomb = bombs[i];

            for (int j = i + 1; j < bombs.length; j++) {
                int[] bomb2 = bombs[j];

                double distance = calculateDistance(bomb, bomb2);

                if (distance <= bomb[2]) {
                    adj.get(i).add(j);
                }
                if (distance <= bomb2[2]) {
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] isBombed = new boolean[bombs.length];

        int maxBombs = 0;

        for (int i = 0; i < bombs.length; i++) {
            maxBombs = Math.max(maxBombs, dfs(i, adj, isBombed));
            Arrays.fill(isBombed, false);
        }


        return maxBombs;
    }

    private double calculateDistance(int[] bomb1, int[] bomb2) {
        long dX = bomb1[0] - bomb2[0];
        long dY = bomb1[1] - bomb2[1];

        return Math.sqrt(dX * dX + dY * dY);
    }

    private int dfs(int bombI, List<List<Integer>> adj, boolean[] isBombed) {
        if (isBombed[bombI]) {
            return 0;
        }

        isBombed[bombI] = true;

        List<Integer> neighbors = adj.get(bombI);

        int count = 1;

        for (int neighbor : neighbors) {
            count += dfs(neighbor, adj, isBombed);
        }

        return count;
    }
}