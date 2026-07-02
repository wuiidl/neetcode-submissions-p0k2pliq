class Solution {
    public int search(int[] nums, int target) {
        // target = 1
        // [3,4,5,6,1,2]
        // [      l   r]
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while(l < r) {
            int m = (l + r) / 2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int pivot = l;

        int result = bs(nums, 0, pivot - 1, target);
        if(result != -1) return result;

        return bs(nums, pivot, n - 1, target);

    }

    private int bs(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }

}
