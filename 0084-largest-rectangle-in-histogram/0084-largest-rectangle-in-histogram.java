class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            int height = heights[i];
            
            while (! stack.empty() && stack.peek().getValue() > height) {
                var rec = stack.pop();
                
                maxArea = Math.max(maxArea, rec.getValue() * (i - rec.getKey()));
                
                start = rec.getKey();
            }
            
            stack.push(new Pair(start, height));
        }
        
        for (var rec : stack) {
            maxArea = Math.max(maxArea, rec.getValue() * (heights.length - rec.getKey()));
        }
        
        return maxArea;
    }
}