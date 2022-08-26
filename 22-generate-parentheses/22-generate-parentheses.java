class Solution {
    private int n = 0;
    
    private void helper(List<String> solutions, String str, int open, int close) {
        if (open < n) {
            helper(solutions, str + "(", open + 1, close);
                
            if (close < open) {
                helper(solutions, str + ")", open, close + 1);
            }
        } else {
            for (int i = 0; i < open - close; i++) {
                str += ")";
            }
            
            solutions.add(str);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        
        List<String> solutions = new ArrayList<>();
        
        helper(solutions, "", 0, 0);
        
        return solutions;
    }
}