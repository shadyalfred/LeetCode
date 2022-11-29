class Solution {
    private List<List<Integer>> subsets = new ArrayList();
    
    private List<Integer> subset;
    
    private int[] nums;
    
    public List<List<Integer>> subsets(int[] nums) {
        subset = new ArrayList();
        
        this.nums = nums;
        
        dfs(0);
        
        return subsets;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            subsets.add(new ArrayList(subset));
            return;
        }
        
        subset.add(nums[i]);
        dfs(i + 1);
        
        subset.remove(subset.size() - 1);
        dfs(i + 1);
    }

}