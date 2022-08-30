class Point {
    public int value;
    public int position;
    public Point(int value, int position) {
        this.value = value;
        this.position = position;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0) {
            return new int[0];
        }
        
        int N = temperatures.length;
        
        int[] answer = new int[temperatures.length];
        
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(temperatures[N - 1], N - 1));
        
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] < stack.peek().value) {
                answer[i] = stack.peek().position - i;
            } else {
                while (!stack.empty() && stack.peek().value <= temperatures[i]) {
                    stack.pop();
                }
                
                if (!stack.empty()) {
                    answer[i] = stack.peek().position - i;
                }
            }
            stack.push(new Point(temperatures[i], i));
        }
        return answer;
    }
}