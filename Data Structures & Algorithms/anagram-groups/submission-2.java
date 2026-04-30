class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> buckets = new HashMap<>();

        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            buckets.putIfAbsent(sb.toString(), new ArrayList<>());
            buckets.get(sb.toString()).add(s);
        }

        return new ArrayList<>(buckets.values());

    }
}
