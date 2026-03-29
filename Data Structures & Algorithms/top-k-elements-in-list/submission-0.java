class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        Set<Integer> items = new HashSet<>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            items.add(n);
        }

        for(int n : items) {
            pq.offer(n);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] r = new int[k];
        for(int i = 0; i < k;i++) {
            r[i] = pq.poll();
        }

        return r;
    }
}
