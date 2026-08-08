class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> heightRuns = new ArrayDeque<>();
        Deque<Integer> heightRunsIndecies = new ArrayDeque<>();

        int maxArea = 0;
        
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!heightRuns.isEmpty() && heights[i] < heightRuns.peek()) {
                int heightRun = heightRuns.pop();
                int heightRunIndex = heightRunsIndecies.pop();

                maxArea = Math.max(maxArea, heightRun * (i - heightRunIndex));
                start = heightRunIndex;
            }

            heightRuns.push(heights[i]);
            heightRunsIndecies.push(start);
        }

        while (!heightRuns.isEmpty()) {
            int heightRun = heightRuns.pop();
            int heightRunIndex = heightRunsIndecies.pop();

            maxArea = Math.max(maxArea, heightRun * (heights.length - heightRunIndex));
        }

        return maxArea;
    }
}