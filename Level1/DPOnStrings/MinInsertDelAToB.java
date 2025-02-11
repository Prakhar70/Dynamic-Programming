package Level1.DPOnStrings;

import java.util.Arrays;

public class MinInsertDelAToB {
    public int minOperations(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        return minOperations(str1, str2, 0, 0, n1, n2);
    }

    private int minOperations(String str1, String str2, int i, int j, int n1, int n2) {

        if (i == n1) {
            return n2 - j;
        } 
        if (j == n2) {
            return n1 - i;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return minOperations(str1, str2, i + 1, j + 1,n1, n2);
        }
        int insertion = 1 + minOperations(str1, str2, i, j + 1, n1, n2);
        int deletion = 1 + minOperations(str1, str2, i + 1, j, n1, n2);
        return Math.min(insertion, deletion);
    }
    public int minOperationsDP(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp=new int[n1+1][n2+1];
        for(int[] arr1d:dp){
            Arrays.fill(arr1d, -1);
        }
        return minOperationsDP(str1, str2, 0, 0, n1, n2, dp);
    }

    private int minOperationsDP(String str1, String str2, int i, int j, int n1, int n2, int[][] dp) {

        if (i == n1) {
            return dp[i][j]=n2 - j;
        } 
        if (j == n2) {
            return dp[i][j]=n1 - i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j]=minOperationsDP(str1, str2, i + 1, j + 1,n1, n2, dp);
        }
        int insertion = 1 + minOperationsDP(str1, str2, i, j + 1, n1, n2,dp);
        int deletion = 1 + minOperationsDP(str1, str2, i + 1, j, n1, n2, dp);
        return dp[i][j]=Math.min(insertion, deletion);
    }
}
