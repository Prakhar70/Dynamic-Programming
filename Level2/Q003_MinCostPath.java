package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q003_MinCostPath {
    public static int[][] prepareMinimumCostPathDP(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int min = Integer.MAX_VALUE;
                if (j + 1 < m) {
                    min = Math.min(min, dp[i][j + 1]);
                }
                if (i + 1 < n) {
                    min = Math.min(min, dp[i + 1][j]);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i][j] = min + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp;
    }

    static class Pair {
        int row;
        int col;
        String ssf;

        Pair(int row, int col, String ssf) {
            this.row = row;
            this.col = col;
            this.ssf = ssf;
        }
        public String toString(){
            return ssf;
        }
    }

    public static void printPath(int[][] dp) {
        int n = dp.length;
        int m = dp[0].length;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0, "(0,0)=>"));
        while (que.size() > 0) {
            Pair rNode = que.remove();
            
            if (rNode.row == n - 1 && rNode.col == m - 1) {
                System.out.println(rNode.ssf);
                continue;
            }
            int min = Integer.MAX_VALUE;
            if (rNode.row + 1 < n && dp[rNode.row + 1][rNode.col] < min) {
                min = dp[rNode.row + 1][rNode.col];
            }
            if (rNode.col + 1 < m && dp[rNode.row][rNode.col + 1] < min) {
                min = dp[rNode.row][rNode.col + 1];
            }
            if (rNode.row + 1 < n && dp[rNode.row + 1][rNode.col] == min) {
                que.add(new Pair(rNode.row + 1, rNode.col,
                        rNode.ssf + "(" + (rNode.row + 1) + "," + rNode.col + ")=>"));
            }
            if (rNode.col + 1 < m && dp[rNode.row][rNode.col + 1] == min) {
                que.add(new Pair(rNode.row, rNode.col + 1,
                        rNode.ssf + "(" + rNode.row + "," + (rNode.col + 1) + ")=>"));
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 6, 1, 1, 3 }, { 9, 1, 1, 0, 5 }, { 0, 7, 5, 2, 0 }, { 4, 3, 0, 4, 7 },
                { 2, 0, 1, 4, 1 } };
        int[][] dp = prepareMinimumCostPathDP(grid);
        print2D(dp);
        printPath(dp);

    }

    private static void print2D(int[][] dp) {
        for(int[] d:dp){
            for(int ele:d){
                System.out.print(ele+"\t");
            }
            System.out.println();
        }
    }
}
