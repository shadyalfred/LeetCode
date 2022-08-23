class MinStack {
    Stack<Integer> minimums = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        
        if (minimums.empty())
            minimums.push(val);
        else
            minimums.push(Math.min(val, minimums.peek()));
            
        stack.push(val);
    }
    
    public void pop() {
        minimums.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimums.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */