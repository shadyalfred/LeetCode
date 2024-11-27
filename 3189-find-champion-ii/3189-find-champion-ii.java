class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            visited[edge[1]] = true;
        }

        boolean foundOneAnswer = false;
        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (foundOneAnswer) {
                    return -1;
                }
                answer = i;
                foundOneAnswer = true;
            }
        }
        return answer;
    }
}