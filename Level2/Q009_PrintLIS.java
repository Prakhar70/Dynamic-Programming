package Level2;
import java.util.LinkedList;
import java.util.Queue;

public class Q009_PrintLIS {
   static class Pair{
        int idx;
        String psf;
        Pair(int idx, String psf){
            this.idx = idx;
            this.psf = psf;
        }
    };
    public static void lengthOfLIS(int[] nums) {
        Queue<Pair> que = new LinkedList<>();
        int n = nums.length;
        int lis = 0;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=0;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    if(dp[i]<dp[j]){
                        dp[i]=dp[j];
                    }
                }
            }
            dp[i]++;
            lis = Math.max(lis, dp[i]);
               
        }
        for(int i=0;i<n;i++){
            if(dp[i]==lis){
                que.add(new Pair(i,nums[i]+""));
            }
        }
        
        while(!que.isEmpty()){

            Pair rNode = que.remove();
            if(dp[rNode.idx]==1){
                System.out.println(rNode.psf);
                continue;
            }
            for(int i=0;i<rNode.idx;i++){
                if(nums[i]<nums[rNode.idx] && dp[i]==dp[rNode.idx]-1)
                    que.add(new Pair(i,rNode.psf+"*"+nums[i]));
            }
        }
    }
    public static void main(String[] args) {
        int[] nums= {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
}
