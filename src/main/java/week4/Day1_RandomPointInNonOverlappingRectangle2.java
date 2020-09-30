package week4;

import java.util.Random;
import java.util.TreeMap;

public class Day1_RandomPointInNonOverlappingRectangle2 {
    Random random = new Random();
    int sum;
    TreeMap<Integer, Integer> map;
    int[][] rects;
    public Day1_RandomPointInNonOverlappingRectangle2(int[][] rects) {
        this.rects = rects;
        sum = 0;
        map = new TreeMap();
        for (int i=0; i<rects.length; i++) {
            int width = rects[i][2] - rects[i][0] + 1;
            int height = rects[i][3] - rects[i][1] + 1;
            sum += width * height;
            map.put(sum, i);
        }
    }

    public int[] pick() {
        int k = map.ceilingKey(random.nextInt(sum) + 1);
        int rect[] = rects[map.get(k)];
        return new int[]{rect[0] + random.nextInt(rect[2] - rect[0] + 1), rect[1] + random.nextInt(rect[3] - rect[1] + 1)};
    }
}
