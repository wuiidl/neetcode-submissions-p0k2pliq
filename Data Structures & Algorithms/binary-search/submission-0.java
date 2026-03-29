class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            int cand = nums[m];
            if(target == cand) {
                return m;
            }else if(cand < target) {
                // less than target
                l = m + 1;
            }else{
                // bigger than target
                r = m - 1;
            }
        }
        return -1;
    }
}
