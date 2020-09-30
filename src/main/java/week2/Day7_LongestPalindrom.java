package week2;

import java.util.HashMap;
import java.util.Map;

public class Day7_LongestPalindrom {
    // 2 case -
    // characters are even so if abc|cba, simply add them
    // characters are odd, then no. of characters - 1 will be taken, but imp case
    // that only one character in middle will occur, even if we have multiple character,
    // occuring odd no of time
    // ex abccccddfff -> include even char ie ccd dcc,
    // select char if after subtracting 1 from count gives even
    // here fccd dccf, but only one character can be included in middle, so we use flag
    // to get if we can include that odd char in middle
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        boolean oddFlag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) res += entry.getValue();
            else {
                oddFlag = true;
                res += entry.getValue() - 1;
            }
        }
        return oddFlag ? res + 1 : res;
    }
}
