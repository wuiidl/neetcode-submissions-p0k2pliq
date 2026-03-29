class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        return Arrays.equals(asBitmap(s), asBitmap(t));
    }

    private int[] asBitmap(String s) {
        int[] bitmap = new int[26];
        for(char c : s.toCharArray()) {
            bitmap[c - 'a']++;
        }
        return bitmap;
    }
}
