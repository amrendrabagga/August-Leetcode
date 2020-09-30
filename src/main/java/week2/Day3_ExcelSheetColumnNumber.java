package week2;

public class Day3_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int []count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'A'] = (int)(c - 'A') + 1;
        }
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            res = 26*res + count[s.charAt(i) - 'A'];
        }
        return res;
    }
}
