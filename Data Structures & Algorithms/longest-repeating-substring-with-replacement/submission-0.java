class Solution {
    public int characterReplacement(String s, int k) {
        // [0, 1, 2, 3, 4, 5] , k = 2


        // frequency map
        // invariant is windowSize - maxfreq of character <= k

        Map<Character, Integer> freq = new HashMap<>();
        int maxF = 0;
        int l = 0;
        int res = 0;

        for(int r = 0; r < s.length();r++) {
            // add count of current character
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, freq.get(s.charAt(r)));

            // sliding window
            while((r - l + 1) - maxF > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, (r - l + 1));
        }
        return res;
    }
}
