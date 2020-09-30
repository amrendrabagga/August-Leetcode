package week2;

import java.util.ArrayList;
import java.util.List;

public class Day5_PascalTraingel2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList(rowIndex+1);
        // Collections.fill(list, 1);
        for (int i=0; i<=rowIndex; i++) {
            list.add(1);
        }
        for (int i=1; i<rowIndex; i++) {
            for (int j=i; j>0; j--) {
                list.set(j, list.get(j) + list.get(j-1));
            }
        }
        return list;
    }
}
