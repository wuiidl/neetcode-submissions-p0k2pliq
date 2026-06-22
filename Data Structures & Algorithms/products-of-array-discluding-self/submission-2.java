class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        for(int i = 0; i < nums.length;i++) {
            for(int j = 0; j < nums.length;j++) {
                if(j != i) output[i] = output[i] * nums[j];
            }
        }
        //return output;
        return pf(nums);
    }  


    private int[] pf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        int[] s = new int[n];
        int[] out = new int[n];

        p[0] = 1;
        s[n - 1] = 1;

        for(int i = 1; i < n;i++) {
            p[i] = nums[i-1] * p[i-1];
        }
        for(int i = n - 2; i >=0; i--) {
            s[i] = nums[i+1] * s[i+1];
        }
        for(int i = 0; i < n;i++) {
            out[i] = p[i] * s[i];
        }
        return out;
    }
}  
