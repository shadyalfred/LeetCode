class Solution {
    private List<List<Integer>> sets = new ArrayList();
    private List<Integer> set = new ArrayList();
    
    private int[] candidates;
    private int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        
        dfs(0, 0);
        
        return sets;
    }
    
    private void dfs(int i, int sum) {
        if (sum == target) {
            sets.add(new ArrayList(set));
        }
        
        if (i == candidates.length || sum > target) {
            return;
        }
        
        for (int j = i; j < candidates.length; j++) {
            set.add(candidates[j]);
            dfs(j, sum + candidates[j]);
            set.remove(set.size() - 1);
        }
    }
}