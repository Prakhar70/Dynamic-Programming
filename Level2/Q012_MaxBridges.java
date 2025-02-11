package Level2;

import java.util.Arrays;

public class Q012_MaxBridges {
    public int maxBridges(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        int n = intervals.length;
        int lis = 0;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=0;
            for(int j = i-1;j>=0;j--){
                if(intervals[j][1]<intervals[i][1]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            lis=Math.max(lis, dp[i]);
        }
        return lis;
    }
}

