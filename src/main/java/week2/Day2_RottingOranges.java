package week2;

import java.util.LinkedList;
import java.util.Queue;

public class Day2_RottingOranges {
    private static int directions[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    private int freshOranges = 0;
    public int orangesRotting(int[][] grid) {
        // bfs starting from rottens orange
        Queue<int[]> queue = new LinkedList();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i,j});
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }
        int time = 0;
        while (!queue.isEmpty() && freshOranges > 0) {
            time++;
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                for (int dir[] : directions) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    queue.offer(new int[]{x,y});
                    grid[x][y] = 2;
                    freshOranges--;
                }
            }
        }
        return freshOranges > 0 ? -1 : time;
    }

    public static void main(String[] args) {
        System.out.println(new Day2_RottingOranges().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
