class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        
        int a, b;
        
        for (var token : tokens) {
            switch (token) {
                case "+":
                    b = nums.pop();
                    a = nums.pop();
                    
                    nums.push(a + b);
                    break;
                    
                case "-":
                    b = nums.pop();
                    a = nums.pop();
                    
                    nums.push(a - b);
                    break;
                    
                case "*":
                    b = nums.pop();
                    a = nums.pop();
                    
                    nums.push(a * b);
                    break;
                    
                case "/":
                    b = nums.pop();
                    a = nums.pop();
                    
                    nums.push(a / b);
                    break;
                    
                default:
                    nums.push(Integer.parseInt(token));
                    break;
            }
        }
        
        return nums.pop();
    }
}