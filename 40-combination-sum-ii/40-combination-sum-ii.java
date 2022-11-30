class Solution {
    List<List<Integer>> combinations = new ArrayList();
    
    List<Integer> combination = new ArrayList();
    
    int[] candidates;
    
    int target;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        this.candidates = candidates;
        this.target = target;
        
        dfs(0, 0);
        
        return combinations;
    }
    
    private void dfs(int i, int sum) {
        if (sum == target) {
            combinations.add(new ArrayList(combination));
            return;
        }
        
        if (i == candidates.length || sum > target) {
            return;
        }
        
        combination.add(candidates[i]);
        dfs(i + 1, sum + candidates[i]);
        combination.remove(combination.size() - 1);
        
        int j = i + 1;
        while (j < candidates.length && candidates[j] == candidates[i]) {
            j++;
        }
        
        dfs(j, sum);
    }
}