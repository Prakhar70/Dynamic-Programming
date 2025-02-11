package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q004_TargetSum {
    static class Pair{
        int row;
        int col;
        String psf;
        Pair(int row, int col,String psf){
            this.row = row;
            this.col = col;
            this.psf= psf;
        }
    }
    static void isSubsetSum(int arr[], int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    boolean noChoice = dp[i - 1][j];
                    boolean yesChoice = false;
                    if (j - arr[i - 1] >= 0) {
                        yesChoice = dp[i - 1][j - arr[i - 1]];
                    }
                    dp[i][j] = noChoice || yesChoice;
                }
            }
        }
        System.out.println(dp[n][target]);
        print2d(dp);
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(n,target,""));
        while(!que.isEmpty()){
            Pair rNode = que.remove();
            if(rNode.col==0 && rNode.row == 0){
                System.out.println(rNode.psf);
                continue;
            }
            if(rNode.row-1>=0 && dp[rNode.row-1][rNode.col]== true){
                que.add(new Pair(rNode.row-1,rNode.col,rNode.psf));
            }
            if(rNode.col-arr[rNode.row-1]>=0 && dp[rNode.row-1][rNode.col-arr[rNode.row-1]]){
                que.add(new Pair(rNode.row-1,rNode.col-arr[rNode.row-1],rNode.psf+arr[rNode.row-1]));
            }
        }
    }

    public static void print2d(boolean[][] matrix){
        for(boolean [] arr:matrix){
            print1d(arr);
            System.out.println();
        }
    }

    private static void print1d(boolean[] arr) {
        for(boolean ele:arr){
            System.out.print(ele);
            System.out.print("\t");
        }
    }
    public static void main(String[] args) {
        int[] arr={4,2,7,1,3};
        int tar = 10;
        isSubsetSum(arr, tar);
    }

}
