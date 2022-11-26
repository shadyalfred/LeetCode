class WordDictionary {
    class Node {
        public boolean isWord;
        public Map<Character, Node> children = new HashMap();
    }

    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        var curr = root;

        for (var c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }

            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(0, this.root, word);
    }

    private boolean dfs(int j, Node curr, String word) {
        for (int i = j; i < word.length(); i++) {
            var c = word.charAt(i);

            if (c == '.') {
                for (var child : curr.children.values()) {
                    if (dfs(i + 1, child, word)) {
                        return true;
                    }
                }

                return false;
            } else {
                if (!curr.children.containsKey(c)) {
                    return false;
                }

                curr = curr.children.get(c);
            }
        }

        return curr.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
