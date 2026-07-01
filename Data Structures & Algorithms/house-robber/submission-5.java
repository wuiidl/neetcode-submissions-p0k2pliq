class Solution {
    public int rob(int[] nums) {
        int rob2back = 0;
        int rob1back = 0;

        for(int n : nums) {
            int tmp = Math.max(n + rob2back, rob1back);
            rob2back = rob1back;
            rob1back = tmp;
        }
        return rob1back;
    }
}
