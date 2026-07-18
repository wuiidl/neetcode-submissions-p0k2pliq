class Solution {
    public int missingNumber(int[] nums) {

        Set<Integer> k = new HashSet<>();

        int n = nums.length;
        
        for(int i : nums) {
            k.add(i);
        }

        for(int i = 0; i <= n;i++) {
            if(!k.contains(i)) return i;
        }

        return 0;
    }
}
