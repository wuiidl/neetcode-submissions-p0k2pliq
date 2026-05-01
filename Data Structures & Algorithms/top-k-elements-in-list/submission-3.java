class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(freq.get(a), freq.get(b)));

        for(Integer key : freq.keySet()) {
            heap.offer(key);
            while(heap.size() > k) {
                heap.poll();
            }
        }
        int idx = 0;
        int[] res = new int[k];
        while(!heap.isEmpty()) {
            res[idx++] = heap.poll();
        }
        return res;
    }
}
