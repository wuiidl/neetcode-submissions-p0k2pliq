class Solution {
    public int rob(int[] nums) {

        if(nums.length < 2) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(
            rob(nums, 0, nums.length - 2),
            rob(nums, 1, nums.length - 1)
        );
    }


    private int rob(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for(int n : Arrays.copyOfRange(nums, start, end + 1)) {
            int tmp = Math.max(prev1, prev2 + n);
            prev2 = prev1;
            prev1 = tmp;
        }
        return prev1;
    }
}
