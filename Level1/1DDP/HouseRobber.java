public class HouseRobber {
    class Pair{
        int with;
        int without;
        Pair(int with , int without){
            this.with=with;
            this.without=without;
        }
    }
    public int houseRobber(int[] money) {
        int n= money.length;
        return Math.max(nonAdjacentTab(money, 0, n-2), nonAdjacentTab(money, 1, n-1));
    }
    private int nonAdjacentTab(int[] nums, int si, int ei){
        int n = nums.length;
        Pair[] dp = new Pair[n];
        for(int i = si;i<=ei;i++){
            if(i==si){
                dp[i]=new Pair(nums[i], 0);
                continue;
            }
            dp[i]=new Pair(dp[i-1].without+nums[i], Math.max(dp[i-1].without, dp[i-1].with));
        }
        return Math.max(dp[ei].with, dp[ei].without);
        
    }
}
