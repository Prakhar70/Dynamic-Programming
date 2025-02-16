package Level2;
import java.util.LinkedList;
import java.util.Queue;

public class Q006_Knapsack {
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n][capacity+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=capacity;j++){
                dp[i][j]=-1;
            }
        }
        return knapSack_(capacity, val, wt, n-1, dp);
    }

    private static int knapSack_(int cap, int[] val, int[] wt, int idx, int[][] dp) {
        if(idx == 0){
            if(cap >= wt[0])
                return dp[idx][cap]=val[0];
            else
                return dp[idx][cap]=0;
        }
        if(dp[idx][cap]!=-1){
            return dp[idx][cap];
        }
        int no = knapSack_(cap, val, wt, idx-1,dp);
        int yes = 0;
        if(cap-wt[idx]>=0){
            yes = val[idx]+knapSack_(cap-wt[idx], val, wt, idx-1,dp);
        }
        return dp[idx][cap]=Math.max(yes,no);
    }

    static int knapSackTab(int capacity, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n][capacity+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=capacity;j++){
                dp[i][j]=-1;
            }
        }
        for(int idx=0;idx<n;idx++){
            for(int cap=0;cap<=capacity;cap++){
                if(idx == 0){
                    if(cap >= wt[0]){
                        dp[idx][cap]=val[0];
                    }else{
                        dp[idx][cap]=0;
                    }
                    continue;
                }
                int no = dp[idx-1][cap];//knapSack_(cap, val, wt, idx-1,dp);
                int yes = 0;
                if(cap-wt[idx]>=0){
                    yes = val[idx]+dp[idx-1][cap-wt[idx]];//knapSack_(cap-wt[idx], val, wt, idx-1,dp);
                }
                dp[idx][cap]=Math.max(yes,no);
            }
        }
        return dp[n-1][capacity];
    }
    static class Pair{
        int i;
        int j;
        String ssf;
        Pair(int i,int j,String ssf){
            this.i=i;
            this.j=j;
            this.ssf = ssf;
        }
        public String toString(){
            return i+"#"+j+"#"+ssf;
        }
    }
    static void PrintknapSack(int capacity, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n][capacity+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=capacity;j++){
                dp[i][j]=-1;
            }
        }
        for(int idx=0;idx<n;idx++){
            for(int cap=0;cap<=capacity;cap++){
                if(idx == 0){
                    if(cap >= wt[0]){
                        dp[idx][cap]=val[0];
                    }else{
                        dp[idx][cap]=0;
                    }
                    continue;
                }
                int no = dp[idx-1][cap];//knapSack_(cap, val, wt, idx-1,dp);
                int yes = 0;
                if(cap-wt[idx]>=0){
                    yes = val[idx]+dp[idx-1][cap-wt[idx]];//knapSack_(cap-wt[idx], val, wt, idx-1,dp);
                }
                dp[idx][cap]=Math.max(yes,no);
            }
        }
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(n-1,capacity,""));
        while(!que.isEmpty()){
            Pair rNode = que.remove();
            if(rNode.i==0){
                if(dp[0][rNode.j]>0){
                    System.out.println(rNode.ssf+0);
                }else{
                    System.out.println(rNode.ssf);
                }
                continue;
            }
            if(dp[rNode.i][rNode.j]==dp[rNode.i-1][rNode.j]){
                que.add(new Pair(rNode.i-1,rNode.j,rNode.ssf));
            }
            if(rNode.j-wt[rNode.i]>=0 && dp[rNode.i][rNode.j] == dp[rNode.i-1][rNode.j-wt[rNode.i]]+val[rNode.i]){
                que.add(new Pair(rNode.i-1,rNode.j-wt[rNode.i],rNode.ssf+rNode.i));
            }
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        PrintknapSack(7, val, wt);
    }
}
