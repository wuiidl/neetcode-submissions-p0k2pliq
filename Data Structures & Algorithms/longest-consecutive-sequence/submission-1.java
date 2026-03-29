class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> ints = new HashSet<>();
        for(int n : nums) {
            ints.add(n);
        }



        for(int i = 0; i < nums.length;i++) {
            if(ints.contains(nums[i] - 1)) continue;
            else {
                int streak = 0;
                int start = nums[i];
                while(ints.contains(start)) {
                    start++;
                    streak++;
                }
                maxLength = Math.max(maxLength, streak);
            }
        }
        return maxLength;
    }
}
