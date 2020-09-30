package week3;

public class Day3_DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int []res = new int[num_people];
        int i = 0;
        int candy = 0;
        while (candies > 0) {
            candy++;
            res[i] += (candies - candy) >= 0 ? candy : candies;
            i = (i + 1) % num_people;
            candies -= candy;
        }
        return res;
    }
}
