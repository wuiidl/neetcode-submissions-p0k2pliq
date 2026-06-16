class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for(int n : nums) {
            if(!dups.add(n)) return true;
        }
        return false;
    }
}