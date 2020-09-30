package week4;

import java.util.ArrayList;
import java.util.List;

public class Day5_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        String multipleOfThree = "Fizz";
        String multipleOfFive = "Buzz";
        for (int i=1; i<=n; i++) {
            String r = "";
            if (i % 3 == 0)
                r += multipleOfThree;
            if (i % 5 == 0)
                r += multipleOfFive;
            res.add(r.isEmpty() ? r + i : r);
        }
        return res;
    }
}
