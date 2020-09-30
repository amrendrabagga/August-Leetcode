package week4;

public class Day4_MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length-1];
        int dp[] = new int[n + 1];
        boolean daysToPay[] = new boolean[n + 1];

        for (int d : days) {
            daysToPay[d] = true;
        }
        dp[0] = 0;
        for (int i=1; i<dp.length; i++) {
            if (!daysToPay[i]) {
                dp[i] = dp[i-1];
                continue;
            }
            int one = dp[Math.max(i-1, 0)] + costs[0];
            int seven = dp[Math.max(i-7, 0)] + costs[1];
            int thirthy = dp[Math.max(i-30, 0)] + costs[2];
            dp[i] = Math.min(Math.min(one, seven), thirthy);
        }
        return dp[dp.length - 1];
    }
}
