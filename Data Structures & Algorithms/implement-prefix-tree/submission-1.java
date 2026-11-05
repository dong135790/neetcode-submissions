class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = this.root;
        for (char letter: word.toCharArray()) {
            int index = letter - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = this.root;
        for (char letter: word.toCharArray()) {
            int index = letter - 'a';
            if (current.children[index] == null) {
                return false;
            } else {
                current = current.children[index];
            }
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        int size = 0;
        for (char letter: prefix.toCharArray()) {
            int index = letter - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
            size++;
            if (size == prefix.length()) {
                return true;
            }
            // System.out.println(size);
        }
        return false;
    }
}
