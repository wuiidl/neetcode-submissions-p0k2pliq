class Solution {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    class Trie {
        TrieNode root = new TrieNode();

        void insert(String w) {
            TrieNode curr = root;
            for(char c : w.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
        }

        int lcp(String word, int prefixLen) {
            TrieNode curr = root;
            int i = 0;
            while(i < Math.min(word.length(), prefixLen)) {
                if(!curr.children.containsKey(word.charAt(i))) {
                    return i;
                }
                curr = curr.children.get(word.charAt(i));
                i++;
            }
            return Math.min(word.length(), prefixLen);
        }
    }



    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 1) return strs[0];

        Trie t = new Trie();

        String shortest = strs[0];
        for(String s : strs) {
            if(shortest.length() > s.length()) {
                shortest = s;
            }
        }

        t.insert(shortest);
        int prefixLen = shortest.length();

        for(String s : strs) {
            prefixLen = t.lcp(s, prefixLen);
        }

        return strs[0].substring(0, prefixLen);
    }
}