package week3;

import java.util.ArrayList;
import java.util.List;

public class Day4_NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<>();
        if (N == 0)
            return new int[0];
        if (N == 1)
            list.add(0);
        for (int i=1; i<10; i++) {
            numsSameConsecDiffUtils(i, N-1, K, list);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    private void numsSameConsecDiffUtils(int i, int N, int K, List<Integer> list) {
        if (N == 0) {
            list.add(i);
            return;
        }
        int j = i%10;
        if (K + j <10)
            numsSameConsecDiffUtils(i*10 + (j+K), N-1, K, list);

        // to avoid adding same number repeatively for ex N=2 K=0,
        // then we avoid case to add 11 11 22 22 33 33 44 44....
        if (K > 0 && j >= K)
            numsSameConsecDiffUtils(i*10 + (j-K), N-1, K, list);
    }
}
