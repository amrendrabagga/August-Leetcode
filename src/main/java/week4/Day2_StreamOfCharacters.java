package week4;

import sun.text.normalizer.Trie;

import java.util.HashMap;
import java.util.Map;

public class Day2_StreamOfCharacters {
    TrieNode root;
    StringBuilder sb;
    public Day2_StreamOfCharacters(String[] words) {
        sb  = new StringBuilder();
        root = new TrieNode('/');
        for (String word : words) {
            insertWord(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode tmp = root;
        for (int i = sb.length() - 1; i>=0 && tmp != null; i--) {
            TrieNode node = tmp.children.get(sb.charAt(i));
            if (node != null && node.isEnd)
                return true;
            tmp = node;
        }
        return false;
    }

    // insert word in reverse order
    private void insertWord(String word) {
        TrieNode tmp = root;
        for (int i=word.length() -1; i>=0 && tmp != null; i--) {
            char c = word.charAt(i);
            TrieNode node = tmp.children.getOrDefault(c, new TrieNode(c));
            tmp.children.put(c, node);
            tmp = node;
        }
        tmp.isEnd = true;
    }
    static class TrieNode {
        char val;
        Map<Character, TrieNode> children;
        boolean isEnd;
        TrieNode(char val) {
            this.val = val;
            children = new HashMap();
        }
    }

    public static void main(String[] args) {
        Day2_StreamOfCharacters obj = new Day2_StreamOfCharacters(new String[]{"c","cd", "f", "kl"});
        System.out.println(obj.query('a'));
        System.out.println(obj.query('b'));
        System.out.println(obj.query('c'));
        System.out.println(obj.query('d'));
        System.out.println(obj.query('e'));
        System.out.println(obj.query('f'));
    }
}
