class Solution {
    private int n = 0;
    
    private void helper(List<String> solutions, StringBuilder sb, int open, int close) {
        if (open < n) {
            helper(solutions, sb.append("("), open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
                
            if (close < open) {
                helper(solutions, sb.append(")"), open, close + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            for (int i = 0; i < open - close; i++) {
                sb.append(")");
            }
            
            solutions.add(sb.toString());
            
            sb.delete(sb.length() - (open - close), sb.length());
            
        }
    }
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        
        List<String> solutions = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder(n * 2);
        
        helper(solutions, sb, 0, 0);
        
        return solutions;
    }
}