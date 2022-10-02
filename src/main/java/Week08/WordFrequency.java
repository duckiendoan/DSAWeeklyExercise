package Week08;
import edu.princeton.cs.algs4.*;


public class WordFrequency {
    public static void main(String[] args) {
        Trie trie = new Trie();
        In in = new In("algs4-data/tale.txt");
        String[] words = in.readAllStrings();
        for (String word: words)
            trie.insert(word);
        StringBuilder sb = new StringBuilder();
        for (Trie.TrieNode n: trie.getRoot().children) {
            printAllNodes(n, sb);
        }
    }

    private static void printAllNodes(Trie.TrieNode current, StringBuilder builder) {
        if (current == null) return;
        builder.append(current.character);
        if (current.isTerminal) {
            System.out.println(builder + ": " + current.wordFreq);
        }
        for (Trie.TrieNode c: current.children)
            if (c != null) {
                printAllNodes(c, builder);
            }
        builder.setLength(builder.length() - 1);
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode existingNode = findNode(word);
        if (existingNode != null) {
            existingNode.wordFreq++;
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c] == null)
                node.children[c] = new TrieNode(c);
            node = node.children[c];
        }
        node.isTerminal = true;
        node.wordFreq = 1;
    }

    public TrieNode findNode(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c] == null)
                return null;
            node = node.children[c];
        }
        if (node.isTerminal)
            return node;
        else return null;
    }

    public TrieNode getRoot() {
        return root;
    }

    class TrieNode {
        boolean isTerminal;
        int wordFreq;
        char character;

        TrieNode[] children = new TrieNode[256];

        public TrieNode(char c) {
            character = c;
            wordFreq = 0;
        }

        public TrieNode(char c, boolean isTerminal) {
            character = c;
            wordFreq = 0;
            this.isTerminal = isTerminal;
        }
    }
}
