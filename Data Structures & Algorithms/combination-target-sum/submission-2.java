class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res.clear(); // just in case the class is reused between runs

        backtrack(nums, target, 0, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] nums, int target, int i , List<Integer> cur) {

        if(target == 0) {
            this.res.add(new ArrayList<>(cur));
            return;
        }
        
        if(target < 0 || i >= nums.length) return;

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], i, cur);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, i + 1, cur);
    }
}
