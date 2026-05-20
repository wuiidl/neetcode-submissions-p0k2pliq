class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for(int i = nums.length - 1; i >= 0; i--) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    res[i] = Math.max(res[i], 1 + res[j]);
                }
            }
        }
        return Arrays.stream(res).max().getAsInt();
    }
}
