import java.util.Arrays;

public class NonAdjacent {
    class Pair{
        int with;
        int without;
        Pair(int with , int without){
            this.with=with;
            this.without=without;
        }
    }
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        Pair p = nonAdjacent(nums,n);
        return Math.max(p.with,p.without);

    }

    private Pair nonAdjacent(int[] nums, int n) {
        if(n==1){
            return new Pair(nums[0],0);
        }
        Pair p = nonAdjacent(nums, n-1);
        return new Pair(p.without+nums[n-1], Math.max(p.with, p.without));
    }
    private int nonAdjacentTab(int[] nums){
        int n = nums.length;
        Pair[] dp = new Pair[n];
        //Arrays.fill(dp, new Pair(0,0));
        for(int i = 0;i<n;i++){
            if(i==0){
                dp[i]=new Pair(nums[i], 0);
                continue;
            }
            dp[i]=new Pair(dp[i-1].without+nums[i], Math.max(dp[i-1].without, dp[i-1].with));
        }
        return Math.max(dp[n-1].with, dp[n-1].without);
        
    }
}
