package week1;

import utils.TrieNode;

import java.util.HashMap;
import java.util.Map;

public class Day5_WordDictionaryEfficient {
    TrieNode root;
    /** Initialize your data structure here. */
    public Day5_WordDictionaryEfficient() {
        root = new TrieNode('/');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            tmp.children.putIfAbsent(c, new TrieNode(c));
            tmp = tmp.children.get(c);
        }
        tmp.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    public boolean search(TrieNode curr, String word, int i) {
        if (i == word.length()) return curr.isEnd;

        if (word.charAt(i) == '.') {
            for (Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
                if (search(entry.getValue(), word, i+1))
                    return true;
            }
            return false;
        }
        if (!curr.children.containsKey(word.charAt(i)))
            return false;
        return search(curr.children.get(word.charAt(i)), word, i+1);
    }

    public static void main(String[] args) {
        Day5_WordDictionaryEfficient obj = new Day5_WordDictionaryEfficient();
        obj.addWord("mad");
        obj.addWord("bad");
        obj.addWord("dad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
