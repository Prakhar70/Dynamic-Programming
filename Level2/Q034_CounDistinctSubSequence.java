package Level2;

import java.util.HashMap;

public class Q034_CounDistinctSubSequence {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            dp[i] = (dp[i - 1] * 2) % MOD;

            if (map.containsKey(ch)) {
                dp[i] = (dp[i] - dp[map.get(ch) - 1] + MOD) % MOD;
            }

            map.put(ch, i);
        }

        return (dp[n] - 1 + MOD) % MOD;
    }
}
