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
            dfs(i, adj, isBombed);

            int countBombs = 0;
            for (int j = 0; j < isBombed.length; j++) {
                if (isBombed[j]) {
                    countBombs++;
                }
                isBombed[j] = false;
            }

            maxBombs = Math.max(maxBombs, countBombs);
        }


        return maxBombs;
    }

    private double calculateDistance(int[] bomb1, int[] bomb2) {
        long dX = bomb1[0] - bomb2[0];
        long dY = bomb1[1] - bomb2[1];

        return Math.sqrt(dX * dX + dY * dY);
    }

    private void dfs(int bombI, List<List<Integer>> adj, boolean[] isBombed) {
        if (isBombed[bombI]) {
            return;
        }

        isBombed[bombI] = true;

        List<Integer> neighbors = adj.get(bombI);

        for (int neighbor : neighbors) {
            dfs(neighbor, adj, isBombed);
        }

        return;
    }
}