class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for(int i = 0; i < nums.length;i++) {
            int comp = target - nums[i];
            if(idx.containsKey(comp)) {
                return new int[]{idx.get(comp), i};
            }
            idx.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
