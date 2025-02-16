package Level2;

import java.util.Arrays;

public class Q022_MatrixMultiplication {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return matrixMultiplication(arr, 1, n - 1,dp);
    }

    private static int matrixMultiplication(int[] arr, int i, int j) {
        if(i==j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int p1=matrixMultiplication(arr,i,k);
            int p2=matrixMultiplication(arr,k+1,j);
            int cost = (arr[i-1]*arr[k]*arr[j])+p1+p2;
            min = Math.min(cost,min);
        }
        return min;
    }
    private static int matrixMultiplication(int[] arr, int i, int j,int[][] dp) {
        if(i==j){
            return dp[i][j]=0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int p1=matrixMultiplication(arr,i,k,dp);
            int p2=matrixMultiplication(arr,k+1,j,dp);
            int cost = (arr[i-1]*arr[k]*arr[j])+p1+p2;
            min = Math.min(cost,min);
        }
        return dp[i][j]=min;
    }
    static int matrixMultiplicationTab(int arr[]) {
        int n = arr.length;
         int[][] dp = new int[n][n];
         for(int gap=1;gap<n;gap++){
             for(int i=1,j=gap;j<n;i++,j++){
                 if(i==j){
                     dp[i][j]=0;
                     continue;
                 }
                 int min = Integer.MAX_VALUE;
                 for(int k=i;k<j;k++){
                     int p1=dp[i][k];//matrixMultiplication(arr,i,k,dp);
                     int p2=dp[k+1][j];//matrixMultiplication(arr,k+1,j,dp);
                     int cost = (arr[i-1]*arr[k]*arr[j])+p1+p2;
                     min = Math.min(cost,min);
                 }
                 dp[i][j]=min;
             }
         }
         return dp[1][n-1]; // code here
     }
    
}
