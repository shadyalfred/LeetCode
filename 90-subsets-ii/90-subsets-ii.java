class Solution {
    List<List<Integer>> subsets = new ArrayList();
    
    List<Integer> subset = new ArrayList();
    
    int[] nums;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
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
        
        int j = i + 1;
        while (j < nums.length && nums[i] == nums[j]) {
            j++;
        }
        dfs(j);
    }
}