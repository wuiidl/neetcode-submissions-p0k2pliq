class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() <= 1) return true;

        char[] c = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int n = c.length;
        int l = 0;
        int r = n - 1;

        while(l <= r && r >= 0) {
            if(Character.isWhitespace(c[l]) || !Character.isLetterOrDigit(c[l])) l++;
            if(Character.isWhitespace(c[r]) || !Character.isLetterOrDigit(c[r])) r--;
            if(c[l] != c[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
