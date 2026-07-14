class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int target, int total, int start, List<Integer> cur) {

        if(total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < nums.length;i++) {
            if(total + nums[i] > target) return; // <-- early exit
            cur.add(nums[i]);
            dfs(nums, target, total + nums[i], i, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
