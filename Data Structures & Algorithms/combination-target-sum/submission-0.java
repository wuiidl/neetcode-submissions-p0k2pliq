class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        backtrack(nums, 0, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int idx, int target, List<Integer> cur) {
        if(target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0 || idx >= nums.length) {
            return;
        }

        cur.add(nums[idx]);
        backtrack(nums, idx, target - nums[idx], cur);
        cur.remove(cur.size() - 1);
        backtrack(nums, idx + 1, target, cur);
    }
}
