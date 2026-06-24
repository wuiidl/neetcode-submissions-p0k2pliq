class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() <= 1) return true;

        char[] c = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int n = c.length;
        int l = 0;
        int r = n - 1;

        while(l <= r && r >= 0) {

            if(c[l] != c[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
