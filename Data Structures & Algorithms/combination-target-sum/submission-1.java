class Solution {

    List<List<Integer>> res;
    int[] arr;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        arr = nums;

        Arrays.sort(arr);

        dfs(0, target, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int index, int target, int total, List<Integer> cur) {

        if(total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index; i < arr.length;i++) {
            if(total + arr[i] > target) return;
            cur.add(arr[i]);
            dfs(i, target, total + arr[i], cur);
            cur.remove(cur.size() - 1);
        }

    }
}
