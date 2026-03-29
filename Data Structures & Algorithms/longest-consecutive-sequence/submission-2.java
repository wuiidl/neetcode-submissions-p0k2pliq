class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> ints = new HashSet<>();
        for(int n : nums) {
            ints.add(n);
        }
        for(int n : nums) {
            if(ints.contains(n - 1)) continue;
            else {
                int len = 0;
                while(ints.contains(n + len)) {
                    len++;
                }
                maxLength = Math.max(maxLength, len);
            }
        }
        return maxLength;
    }
}
