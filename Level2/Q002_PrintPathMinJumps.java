
package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q002_PrintPathMinJumps {
    public static int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                continue;
            }
            int jumps = nums[i];
            int ans = Integer.MAX_VALUE;
            for (int jmp = 1; jmp <= jumps && i + jmp < n; jmp++) {
                if (dp[i + jmp] == null) {
                    continue;
                }
                ans = Math.min(ans, dp[i + jmp]);
            }
            if (ans != Integer.MAX_VALUE)
                dp[i] = ans + 1;

        }
        return dp[0];
    }

    public static class Pair {
        int index;
        String path;

        Pair(int index, String path) {
            this.index = index;
            this.path = path;
        }
    }

    public static void printAllJumps(int[] arr) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] == 0) {
                continue;
            }
            int jumps = arr[i];
            int ans = Integer.MAX_VALUE;
            for (int jmp = 1; jmp <= jumps && i + jmp < n; jmp++) {
                if (dp[i + jmp] == null) {
                    continue;
                }
                ans = Math.min(ans, dp[i + jmp]);
            }
            if (ans != Integer.MAX_VALUE)
                dp[i] = ans + 1;
        }
        System.out.println(dp[0]);

        Queue<Pair> que = new LinkedList<>();
        Pair pair = new Pair(0, "0");
        que.add(pair);
        while (!que.isEmpty()) {
            Pair rNode = que.remove();
            if (rNode.index == n - 1) {
                System.out.println(rNode.path);
            }

            int jumps = arr[rNode.index];
            int cIndex = rNode.index;
            String psf = rNode.path;

            for (int j = 1; j <= jumps && cIndex + j < n; j++) {
                if (dp[cIndex + j] != null && dp[cIndex + j] == dp[cIndex] - 1) {
                    que.add(new Pair(cIndex + j, psf + " " + (cIndex + j)));
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
        printAllJumps(arr);
    }

}
