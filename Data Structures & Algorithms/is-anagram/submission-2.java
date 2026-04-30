class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        int[] s1 = new int[26];
        int[] t1 = new int[26];

        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            s1[idx]++;
        }

        for(char c : t.toCharArray()) {
            int idx = c - 'a';
            t1[idx]++;
        }

        for(int i = 0; i < s1.length;i++){
            if(s1[i] != t1[i]) return false;
        }
        return true;
    }
}
