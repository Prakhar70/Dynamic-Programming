package Level2;

import java.util.Arrays;

public class Q013_RussainDolls {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            return a[0]-b[0];
        });
        int n = envelopes.length;
        int lis = 0;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=0;
            for(int j = i-1;j>=0;j--){
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            lis=Math.max(lis, dp[i]);
        }
        return lis;
    }
}
