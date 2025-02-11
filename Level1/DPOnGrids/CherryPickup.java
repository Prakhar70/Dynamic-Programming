package Level1.DPOnGrids;

import java.util.Arrays;

public class CherryPickup {
    public int cherryPickup(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dir = { { 1, -1 }, { 1, 0 }, { 1, 1 } };
        return cherryPickup_(matrix, 0, 0, m - 1, n, m, dir);
    }

    private int cherryPickup_(int[][] matrix, int i1, int j1, int j2, int n, int m, int[][] dir) {
        if (i1 == n - 1) {
            if (j1 == j2) {
                return matrix[i1][j1];
            } else {
                return matrix[i1][j1] + matrix[i1][j2];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int[] d : dir) {
            for (int[] r : dir) {
                int r1 = i1 + d[0];
                int c1 = j1 + d[1];
                int c2 = j2 + r[1];
                if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < m && c2 >= 0 && c2 < m) {
                    ans = Math.max(ans, cherryPickup_(matrix, r1, c1, c2, n, m, dir));
                }
            }
        }
        if (j1 == j2) {
            return ans + matrix[i1][j1];
        }
        return ans + matrix[i1][j1] + matrix[i1][j2];

    }

    public int cherryPickupDP(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dir = { { 1, -1 }, { 1, 0 }, { 1, 1 } };
        int[][][] dp = new int[n][m][m];
        for (int[][] dp2 : dp) {
            for (int[] dp1 : dp2) {
                Arrays.fill(dp1, -1);
            }
        }
        return cherryPickupDP(matrix, 0, 0, m - 1, n, m, dir, dp);
    }

    private int cherryPickupDP(int[][] matrix, int i1, int j1, int j2, int n, int m, int[][] dir, int[][][] dp) {
        if (i1 == n - 1) {
            if (j1 == j2) {
                return dp[i1][j1][j2] = matrix[i1][j1];
            }
            return dp[i1][j1][j2] = matrix[i1][j1] + matrix[i1][j2];
        }
        if (dp[i1][j1][j2] != -1) {
            return dp[i1][j1][j2];
        }
        int ans = Integer.MIN_VALUE;
        for (int[] d : dir) {
            for (int[] r : dir) {
                int r1 = i1 + d[0];
                int c1 = j1 + d[1];
                int c2 = j2 + r[1];
                if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < m && c2 >= 0 && c2 < m) {
                    ans = Math.max(ans, cherryPickupDP(matrix, r1, c1, c2, n, m, dir, dp));
                }
            }
        }
        if (j1 == j2) {
            return dp[i1][j1][j2] = ans + matrix[i1][j1];
        }
        return dp[i1][j1][j2] = ans + matrix[i1][j1] + matrix[i1][j2];
    }

    public int cherryPickupTab(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dir={{1,-1},{1,0},{1,1}};
        int[][][] dp=new int[n][m][m];
        for(int i1 = n-1;i1>=0;i1--){
            for(int j1 = 0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    if(i1 == n-1){
                        if(j1==j2){
                            dp[i1][j1][j2]=matrix[i1][j1];
                            continue;
                        }
                        dp[i1][j1][j2]=matrix[i1][j1]+matrix[i1][j2];
                        continue;
                    }
                    int ans=Integer.MIN_VALUE;
                    for(int[] d:dir){
                        for(int[] r:dir){
                            int r1 = i1+d[0];
                            int c1 = j1+d[1];
                            int c2 = j2+r[1];
                            if(r1>=0 && r1<n && c1>=0 && c1<m && c2>=0 && c2<m){
                                ans=Math.max(ans, dp[r1][c1][c2]);
                            }
                        }
                    }
                    if(j1==j2){
                        dp[i1][j1][j2]=ans+matrix[i1][j1];
                        continue;
                    }
                    dp[i1][j1][j2]=ans+matrix[i1][j1]+matrix[i1][j2];                 
                }
            }
        }
        return dp[0][0][m-1];
    }
}
