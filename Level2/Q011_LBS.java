package Level2;

public class Q011_LBS {
    public static int longestBitonicSequence(int[] nums, int n) {
        int lbs = 0;
        int[] dp=new int[n];
        int[] dp2=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=0;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            //lis=Math.max(lis, dp[i]);
        }

        for(int i=n-1;i>=0;i--){
            dp2[i]=0;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i]){
                    dp2[i]=Math.max(dp2[i],dp2[j]);
                }
            }
            dp2[i]++;
            lbs=Math.max(lbs, dp2[i]+dp[i]-1);
        }
        return lbs;
    }
    //Gfg variation
    public static int LongestBitonicSequence(int n, int[] nums) {
        int lbs = 0;
        int[] dp=new int[n];
        int[] dp2=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=0;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            //lis=Math.max(lis, dp[i]);
        }

        for(int i=n-1;i>=0;i--){
            dp2[i]=0;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i]){
                    dp2[i]=Math.max(dp2[i],dp2[j]);
                }
            }
            dp2[i]++;
            if(dp2[i]>1 && dp[i]>1)
                lbs=Math.max(lbs, dp2[i]+dp[i]-1);
        }
        return lbs;
    }
}
