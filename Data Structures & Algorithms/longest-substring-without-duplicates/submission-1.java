class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()) return 0;

        Set<Character> win = new HashSet<>();
        int max = 0; // one 
        int n = s.length();
        int l = 0;
        for(int r = 0; r < n;r++) {
            while(win.contains(s.charAt(r))) {
                win.remove(s.charAt(l));
                l++;
            }
            win.add(s.charAt(r));
            max = Math.max(max, r - l + 1);//inclusive boundaries
        }


        return max;
    }
}
