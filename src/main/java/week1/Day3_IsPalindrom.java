package week1;

public class Day3_IsPalindrom {
    public boolean isPalindrome(String s) {
        String fixedString = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c))
                fixedString += c;
        }

        fixedString = fixedString.toLowerCase();
        int i = 0;
        int j = fixedString.length() - 1;
        while (i < j) {
            if (fixedString.charAt(i) != fixedString.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindromeEfficient(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) i++;
            else if (!Character.isLetterOrDigit(s.charAt(j))) j--;
            else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            else {
                i++; j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Day3_IsPalindrom().isPalindrome(".,"));
        System.out.println(new Day3_IsPalindrom().isPalindromeEfficient("A man, a plan, a canal: Panama"));
    }

}
