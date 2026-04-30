class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for(int i : nums) {
            if(!dups.add(i)) return true;
        }
        return false;
    }
}