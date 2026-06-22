class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        for(int i = 0; i < nums.length;i++) {
            for(int j = 0; j < nums.length;j++) {
                if(j != i) output[i] = output[i] * nums[j];
            }
        }
        return output;
    }   
}  
