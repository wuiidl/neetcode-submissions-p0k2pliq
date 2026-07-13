
class TrieNode {
    TrieNode[] lvs = new TrieNode[26];
    boolean isEndOfWord = false;
}


class WordDictionary {

    private TrieNode t = new TrieNode();

    public WordDictionary() {}

    public void addWord(String word) {
        TrieNode curr = this.t;
        for(char c : word.toCharArray()) {
            if(curr.lvs[c - 'a'] == null) {
                curr.lvs[c - 'a'] = new TrieNode();
            }
            curr = curr.lvs[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, t);
    }

    private boolean dfs(String word, int start, TrieNode root) {
        TrieNode curr = root;

        for(int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode n : curr.lvs) {
                    if(n != null && dfs(word, i + 1, n)) return true;
                }
                return false;
            } else {
                if(curr.lvs[c - 'a'] == null) {
                    return false;
                }
                curr = curr.lvs[c - 'a'];
            }
        }
        return curr.isEndOfWord;
    }
}
