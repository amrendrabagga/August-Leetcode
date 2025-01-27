package week4;

import java.util.Arrays;
import java.util.Random;

public class Day1_RandomPointInNonOverlappingRectangleEfficient {
    private final int[] sums;
    private final int[][] rects;
    private final Random rand = new Random();

    public Day1_RandomPointInNonOverlappingRectangleEfficient(int[][] rects)
    {
        this.rects = rects;
        sums = new int[rects.length];
        int sum = 0, index;
        for (int i = 0; i < rects.length; i++)
        {
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            sums[i] = sum;
        }
    }

    public int[] pick()
    {
        int lo = 0, hi = sums.length - 1;
        int target = rand.nextInt(sums[sums.length - 1]);

        while (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (sums[mid] > target) hi = mid;
            else lo = mid + 1;
        }

        int[] rect = rects[lo];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int base = sums[lo] - width * height;
        return new int[]{rect[0] + (target - base) % width, rect[1] + (target - base) / width};
    }

    public static void main(String[] args) {
        int rects[][] = {{-2, -2, -1, -1}, {1, 0, 3, 0}};
        Day1_RandomPointInNonOverlappingRectangleEfficient obj =
                new Day1_RandomPointInNonOverlappingRectangleEfficient(rects);

        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));

    }
}
