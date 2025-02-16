package Level2;

public class Q025_BooleanParenthesization {
    static class Pair{
        int nT;
        int nF;
        Pair(int nT, int nF){
            this.nT = nT;
            this.nF = nF;
        }
        Pair(){
            this.nF = 0;
            this.nT = 0;
        }
    }
    static int countWays(String s) {
        int n = s.length();
        Pair[][] dp = new Pair[n][n];
        return countWays(s,0,n-1, dp).nT;
    }
    static Pair countWays(String s, int si , int ei, Pair[][] dp){
        if(si == ei){
            if(s.charAt(si)=='T'){
                return dp[si][ei]=new Pair(1,0);
            }else{
                return dp[si][ei]=new Pair(0,1);
            }
        }
        if(dp[si][ei]!=null){
            return dp[si][ei];
        }
        Pair mans = new Pair();
        for(int k = si+1;k<=ei-1; k+=2){
            Pair lans = dp[si][k-1];
            Pair rans = dp[k+1][ei];
            char op  = s.charAt(k);
            Pair ans = new Pair();
            if(op == '|'){
                ans.nT = (lans.nT*rans.nT) + (lans.nF*rans.nT) + (lans.nT*rans.nF);
                ans.nF = lans.nF * rans.nF;
            }else if (op == '&'){
                ans.nF = (lans.nF*rans.nF) + (lans.nT*rans.nF) + (lans.nF*rans.nT);
                ans.nT = lans.nT * rans.nT;
            }else{
                ans.nT = (lans.nT* rans.nF) + (lans.nF * rans.nT);
                ans.nF = (lans.nT * rans.nT) + (lans.nF * rans.nF);
            }
            mans.nT+=ans.nT;
            mans.nF+=ans.nF;
        }
        return dp[si][ei]=mans;
    }
    static int countWaysTab(String s) {
        int n = s.length();
        Pair[][] dp = new Pair[n][n];
        for(int gap=0;gap<n;gap++){
            for(int si=0,ei=gap;ei<n;si++,ei++){
                if(si == ei){
                    if(s.charAt(si)=='T'){
                        dp[si][ei]=new Pair(1,0);
                    }else{
                        dp[si][ei]=new Pair(0,1);  
                    }
                    continue;
                }
                Pair mans = new Pair();
                for(int k = si+1;k<=ei-1; k+=2){
                    Pair lans = dp[si][k-1];
                    Pair rans = dp[k+1][ei];
                    char op  = s.charAt(k);
                    Pair ans = new Pair();
                    if(op == '|'){
                        ans.nT = (lans.nT*rans.nT) + (lans.nF*rans.nT) + (lans.nT*rans.nF);
                        ans.nF = lans.nF * rans.nF;
                    }else if (op == '&'){
                        ans.nF = (lans.nF*rans.nF) + (lans.nT*rans.nF) + (lans.nF*rans.nT);
                        ans.nT = lans.nT * rans.nT;
                    }else{
                        ans.nT = (lans.nT* rans.nF) + (lans.nF * rans.nT);
                        ans.nF = (lans.nT * rans.nT) + (lans.nF * rans.nF);
                    }
                    mans.nT+=ans.nT;
                    mans.nF+=ans.nF;
                }
                dp[si][ei]=mans;
            }
        }
        return dp[0][n-1].nT;
    }
}
