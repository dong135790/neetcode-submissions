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
        // TrieNode base = this.root;
        TrieNode current = this.root;

        for (char letter: word.toCharArray()) {
            int index = letter - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            // base.children[index] = current;
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return match(word, 0, this.root);
    }

    boolean match(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }
        char letter = word.charAt(index);
        if (letter == '.') {
            for (TrieNode child: node.children) {
                if (child != null && match(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children[letter - 'a'];
            return child != null && match(word, index + 1, child);
        }
    }
}
