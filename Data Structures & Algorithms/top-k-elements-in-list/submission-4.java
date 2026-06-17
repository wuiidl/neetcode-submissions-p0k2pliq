class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length == 1) return nums;

        // 
        Map<Integer, Integer> freq = new HashMap<>();

        for(int n : nums) {
            // value -> freq
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for(Map.Entry<Integer, Integer> q : freq.entrySet()) {
            pq.offer(new int[]{q.getValue(), q.getKey()});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0 ; i < k;i++) {
            res[i] = pq.poll()[1];
        }
        return res;
    }
}
