package week5;

import java.util.HashMap;
import java.util.Map;

public class Day2_LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] A) {

        Map<Integer, Integer> parent = new HashMap();
        for (int a : A) {
            for (int fact=2; fact*fact <= a; fact++) {
                if (a % fact == 0) {
                    union(a, fact, parent);
                    union(a, a/fact, parent);
                }
            }
        }
        int max = 1;
        Map<Integer, Integer> freq = new HashMap();
        for (int a : A) {
            int f = find(a, parent);
            if (freq.containsKey(f)) {
                freq.put(f, freq.get(f) + 1);
                max = Math.max(max, freq.get(f));
            }
            else freq.put(f, 1);
        }
        return max;
    }

    private void union(int n, int m, Map<Integer, Integer> parent) {
        int findN = find(n, parent);
        int findM = find(m, parent);
        if (findN < findM) parent.put(findM, findN);
        else parent.put(findN, findM);
    }

    private int find(int x, Map<Integer, Integer> parent) {
        if (parent.get(x) == null) parent.put(x, x);
        while (x != parent.get(x)) {
            x = parent.get(x);
        }
        return x;
    }
}
