class Solution {
    // [5,5,1,1,1,5,5]
    public int majorityElement(int[] nums) {
        int cand = 0;
        int count = 0;
        for(int n : nums) {
            if(count == 0) {
                cand = n;
            }
            count += (cand == n) ? 1 : -1;
        }
        return cand;
    }
}