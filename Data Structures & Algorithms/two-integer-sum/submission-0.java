class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i = 0; i < nums.length;i++) {
            int comp = target - nums[i];
            if(cache.containsKey(comp)) {
                return new int[]{ cache.get(comp), i };
            }
            cache.put(nums[i], i);
        }
        return new int[0];
    }
}
