class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }


    private int rob(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i = start; i < end;i++) {
            int tmp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = tmp;
        }
        return prev1;
    }
}
