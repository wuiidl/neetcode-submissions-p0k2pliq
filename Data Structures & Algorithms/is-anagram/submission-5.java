class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] ht = new int[26];

        for(int i = 0; i < s.length(); i++) {
            ht[s.charAt(i) - 'a']++;
            ht[t.charAt(i) - 'a']--;
        }

        for(int n : ht) {
            if(n != 0) return false;
        }
        return true;
    }
}
