package week1;

import java.util.regex.Pattern;

public class Day1_DetectCapital {
    public boolean detectCapitalUse(String word) {
        String regex = "^([A-Z]?)+|[a-z]+|[A-Z]{1}[a-z]+$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(word).matches()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Day1_DetectCapital obj = new Day1_DetectCapital();
        System.out.println(obj.detectCapitalUse("IND"));
        System.out.println(obj.detectCapitalUse("india"));
        System.out.println(obj.detectCapitalUse("INDa"));
        System.out.println(obj.detectCapitalUse("India"));
    }

}
