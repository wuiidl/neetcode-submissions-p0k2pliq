class PrefixTree {

    private final Node root = new Node();

    private static class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    public PrefixTree() {}

    public void insert(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node n = doSearch(word);
        return n != null && n.isEnd;
    }

    private Node doSearch(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return null;
            } else {
                curr = curr.children[idx];
            }
        }
        return curr;
    }

    public boolean startsWith(String prefix) {
        return doSearch(prefix) != null;
    }
}
