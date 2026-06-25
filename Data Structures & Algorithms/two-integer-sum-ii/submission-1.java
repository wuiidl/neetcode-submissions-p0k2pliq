class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0;
        int r = n - 1;
        while(l < r) {
            int vl = numbers[l];
            int vr = numbers[r];
            int curr = vl + vr;
            if(curr > target) {
                r--;
            }else if(curr == target) {
                return new int[] {l + 1, r + 1};
            }else {
                // curr < target
                l++;
            }
        }
        return new int[] {l + 1, r + 1};
    }
}
