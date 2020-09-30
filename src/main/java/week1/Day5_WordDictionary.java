package week1;

import utils.TrieNode;

import java.util.HashMap;
import java.util.Map;

public class Day5_WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public Day5_WordDictionary() {
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
        TrieNode tmp = root;
        return wordSearchUtils(word, tmp);
    }

    private boolean wordSearchUtils(String word, TrieNode tmp) {
        if (tmp == null) return false;
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (char next : tmp.children.keySet()) {
                    if (wordSearchUtils(word.substring(i+1), tmp.children.get(next)))
                        return true;
                }
            }
            if (!tmp.children.containsKey(word.charAt(i))) return false;
            tmp = tmp.children.get(word.charAt(i));
        }
        return tmp != null && tmp.isEnd;
    }


    public static void main(String[] args) {
        Day5_WordDictionary obj = new Day5_WordDictionary();
        obj.addWord("mad");
        obj.addWord("bad");
        obj.addWord("dad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));

//        System.out.println((char)(97+25));
    }
}
