package week2;

import java.util.*;

public class Day6_IteratorForCombination {
    public static void main(String[] args) {
        Day6_IteratorForCombination obj = new Day6_IteratorForCombination("abc", 2);
        System.out.println(obj.it.next());// ab
        System.out.println(obj.it.next());// ac
        System.out.println(obj.it.next());// bc
        System.out.println(obj.it.hasNext());// false

    }

    Iterator<String> it;
    public Day6_IteratorForCombination(String characters, int combinationLength) {
        it = generateAllCombination(characters, combinationLength);
    }

    public String next() {
        return it.next();
    }

    public boolean hasNext() {
        return it.hasNext();
    }

    private Iterator<String> generateAllCombination(String characters, int combinationLength) {
        // 3-> 8 abc 000 {} 001 {c} 010 {b} 100 {a}
        Set<String> res = new TreeSet();
        int l = characters.length();
        int n = (int)Math.pow(2, l);
        for (int i=1; i<n; i++) {
            String tmp = "";
            for (int j=0; j < l; j++) {
                if ((i & (1<<j)) > 0) {
                    tmp += characters.charAt(j);
                }
            }
            if (tmp.length() == combinationLength)
                res.add(tmp);
        }
        return res.iterator();
    }
}
