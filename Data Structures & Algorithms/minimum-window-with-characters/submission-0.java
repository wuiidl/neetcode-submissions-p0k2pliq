class Solution {
    public String minWindow(String s, String t) {

        if(t.isEmpty()) return "";

        Map<Character, Integer> tc = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();


        // count the characters in t
        for(char c : t.toCharArray()) {
            tc.put(c, tc.getOrDefault(c, 0) + 1);
        }

        // this will never change
        final int need = tc.size();

        int have = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        
        // left ptr
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            win.put(c, win.getOrDefault(c, 0) + 1);

            if(tc.containsKey(c) && win.get(c).equals(tc.get(c))) {
                have++; // increment everytime we find a matching character and freq
            }

            // we have what we need. now we attempt to shrink the window
            while(have == need) {
                if((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                win.put(leftChar, win.get(leftChar) - 1);
                if(tc.containsKey(leftChar) && win.get(leftChar) < tc.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
