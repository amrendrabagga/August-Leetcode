package week3;

public class Day5_GoatLatin {

    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();

        String[] words = S.split("\\s");

        StringBuilder repeat = new StringBuilder("a");
        for (String word : words) {
            if (isVowel(word.charAt(0)))
                sb.append(word);
            else
                sb.append(word.substring(1)).append(word.charAt(0));
            sb.append("ma").append(repeat).append(" ");
            repeat.append("a");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        Day5_GoatLatin obj = new Day5_GoatLatin();
        System.out.println(obj.toGoatLatin("I am Amrendra"));
    }

}
