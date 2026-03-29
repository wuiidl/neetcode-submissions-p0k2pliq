class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> cache = new HashMap<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String m = String.valueOf(c);
            cache.putIfAbsent(m, new ArrayList<>());
            cache.get(m).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(cache.values());
        return res;
    }
}
