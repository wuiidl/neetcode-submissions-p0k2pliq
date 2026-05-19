class Solution {
    public int removeElement(int[] nums, int v) {
        int k = 0;
        for(int n : nums) {
            if(n != v) nums[k++] = n;
        }
        return k;
    }
}