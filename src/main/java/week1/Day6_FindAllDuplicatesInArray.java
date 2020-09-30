package week1;

import java.util.ArrayList;
import java.util.List;

public class Day6_FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            // if we are revisiting index ie value at particular index is already negative,
            // means we previously visited so that index is added in our result
            if (nums[index] < 0) res.add(index + 1);
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Day6_FindAllDuplicatesInArray().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
