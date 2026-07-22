class Trie {
    Trie[] children = new Trie[26];
    int idx = -1;
    int refs = 0;

    void insert(String word, int idx) {
        Trie curr = this;
        curr.refs++;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Trie();
            }
            curr = curr.children[index];
            curr.refs++;
        }
        curr.idx = idx;
    }
}


class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        Trie root = new Trie();
        for(int i = 0; i < words.length;i++) {
            // seed the trie with the words and the index in the arrays
            root.insert(words[i], i);
        }

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(i, j, board, words, root);
            }
        }
        
        return res;
    }


    private void dfs(int r, int c, char[][] board, String[] words, Trie curr) {

        int ROW = board.length;
        int COL = board[0].length;

        if(r < 0 || r >= ROW || c < 0 || c >= COL // out of bounds
        || board[r][c] == '*'  // already visited
        || curr.children[board[r][c] - 'a'] == null // no children
        ) {
            return;
        }

        char tmp = board[r][c]; // store the value;
        board[r][c] = '*';

        Trie prev = curr;
        curr = curr.children[tmp - 'a'];

        if(curr.idx != -1) {
            res.add(words[curr.idx]);
            curr.idx = -1;
            curr.refs--;
            if(curr.refs == 0) {
                curr = null;
                prev.children[tmp - 'a'] = null;
                board[r][c] = tmp;
                return;
            }
        }

        dfs(r + 1, c, board, words, curr);
        dfs(r - 1, c, board, words, curr);
        dfs(r, c + 1, board, words, curr);
        dfs(r, c - 1, board, words, curr);

        board[r][c] = tmp; // restore!
    }
}
