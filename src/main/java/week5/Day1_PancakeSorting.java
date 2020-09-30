package week5;

import java.util.ArrayList;
import java.util.List;

public class Day1_PancakeSorting {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList();
        for (int n = A.length; n>0; n--) {
            int index = find(A, n);
            flip(A, index);
            flip(A, n-1);
            res.add(index + 1);
            res.add(n);
        }
        return res;
    }

    private int find(int []A, int target) {
        for (int i=0; i<A.length; i++) {
            if (A[i] == target)
                return i;
        }
        return -1;
    }

    private void flip(int A[], int j) {
        int i=0;
        while (i < j) {
            int tmp = A[i];
            A[i++] = A[j];
            A[j--] = tmp;
        }
    }
}
