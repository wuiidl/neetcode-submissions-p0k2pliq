class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> buckets = new HashMap<>();

        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            buckets.putIfAbsent(new String(c), new ArrayList<>());
            buckets.get(new String(c)).add(s);
        }
        
        List<List<String>> res = new ArrayList();
        buckets.values().forEach(l -> res.add(l));
        return res;
    }
}
