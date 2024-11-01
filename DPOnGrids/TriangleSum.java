package DPOnGrids;

public class TriangleSum {
    public int minTriangleSum(int[][] triangle) {
        int n =triangle.length;
        int[][] dp = new int[n][n];
        int[][] dir ={{1,0},{1,1}};
        for(int r=n-1;r>=0;r--){
            for(int c=0;c<=r;c++){
                int min = Integer.MAX_VALUE;
                for(int[] d:dir){
                    int row = r+d[0];
                    int col = c+d[1];
                    if(row<n){
                        min=Math.min(min, dp[row][col]);
                    }
                }
                if (min==Integer.MAX_VALUE) {
                    dp[r][c]=triangle[r][c];
                }else{
                    dp[r][c]=triangle[r][c]+min;
                }
            }
        }
        return dp[0][0];
    }
}
