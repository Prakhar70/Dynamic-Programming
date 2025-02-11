package Level1.MCM;

import java.util.Arrays;
import java.util.List;

public class MinCuts {
    public int minCost(int rodLen, List<Integer> cuts) {
        int c = cuts.size();
		int[] arr= new int[c];
		int i=0;
		for(int ele:cuts){
			arr[i++]=ele;
		}
		return minCost(rodLen, arr);
    }
	public int minCost(int n, int[] cuts) {
		int len=cuts.length;
        int si = 0;
        int ei = len - 1;
        return minCost(si, ei, cuts, n);
    }

    private int minCost(int si, int ei, int[] cuts, int n) {
        
        if(si>ei){
            return 0;
        }
        int el=(ei+1<cuts.length)?cuts[ei+1]:n;
        int sl=(si-1>=0)?cuts[si-1]:0;
        int cost = el-sl;
        int mini = Integer.MAX_VALUE;
        for(int k=si;k<=ei;k++){
            int l = minCost(si, k-1,cuts, n);
            int r = minCost(k+1, ei, cuts, n);
            mini=Math.min(mini, l+r);
        }
        return mini+cost;
    }
    public int minCostDP(int n, int[] cuts) {
		int len=cuts.length;
        int si = 0;
        int ei = len - 1;
        int[][] dp = new int[len][len];
        for(int[] ele:dp){
            Arrays.fill(ele, -1);
        }
        return minCostDP(si, ei, cuts, n, dp);
    }

    private int minCostDP(int si, int ei, int[] cuts, int n, int[][] dp) {
        
        if(si>ei){
            return dp[si][ei]=0;
        }
        if(dp[si][ei]!=-1){
            return dp[si][ei];
        }
        int el=(ei+1<cuts.length)?cuts[ei+1]:n;
        int sl=(si-1>=0)?cuts[si-1]:0;
        int cost = el-sl;
        int mini = Integer.MAX_VALUE;
        for(int k=si;k<=ei;k++){
            int l = minCostDP(si, k-1,cuts, n, dp);
            int r = minCostDP(k+1, ei, cuts, n, dp);
            mini=Math.min(mini, l+r);
        }
        return dp[si][ei]=mini+cost;
    }
}
