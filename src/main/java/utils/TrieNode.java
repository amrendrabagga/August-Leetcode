package utils;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public char val;
    public Map<Character, TrieNode> children = new HashMap<>(26);
    public boolean isEnd;
    public TrieNode(char val) {
        this.val = val;
    }
}
