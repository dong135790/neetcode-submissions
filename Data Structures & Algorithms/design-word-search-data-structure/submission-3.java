class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = this.root;
        for (char letter: word.toCharArray()) {
            int i = letter - 'a';
            if (current.children[i] == null) {
                current.children[i] = new TrieNode();
            }
            current = current.children[i];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this.root);
    }

    public boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }

        char letter = word.charAt(index);
        if (letter == '.') {
            for (TrieNode child: node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children[letter - 'a'];
            return child != null && dfs(word, index + 1, child);
        }
    }
}
