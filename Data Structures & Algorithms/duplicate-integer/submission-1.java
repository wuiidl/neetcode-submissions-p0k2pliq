class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dupes = new HashSet<>();
        for(int n : nums) {
            if(!dupes.add(n)) {
                return true;
            }
        }
        return false;
    }
}