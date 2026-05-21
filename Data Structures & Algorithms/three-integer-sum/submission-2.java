class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue; // skip this one
            }
            Set<Integer> seen = new HashSet<>();
            for(int j = i + 1; j < nums.length;j++) {
                int comp = -(nums[i] + nums[j]);
                if(seen.contains(comp)) {
                    res.add(List.of(nums[i], nums[j], comp));
                    while(j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                }
                seen.add(nums[j]);
            }
        }
        return res;
    }
}
