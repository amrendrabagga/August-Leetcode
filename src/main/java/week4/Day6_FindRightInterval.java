package week4;

import java.util.TreeMap;

public class Day6_FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 1)
            return new int[]{-1};

        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i=0; i<intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int res[] = new int[intervals.length];

        for (int i=0;i <intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key == null ? -1: map.get(key);
        }
        return res;
    }
}
