package Level2;

public class Q016_NumTrees {
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0]=dp[1]=1;
        for(int i =2;i<=n;i++){
            int si = 0;
            int ei = i-1;
            int ans =0;
            while(si<=ei){
                if(si==ei){
                    ans+=dp[si]*dp[ei];
                }else{
                    ans+=dp[si]*dp[ei]*2;
                }
                si++;
                ei--;
            }
            dp[i]=ans;
        }
        return dp[n];
    }
}
