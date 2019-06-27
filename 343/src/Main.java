public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.integerBreak(10));
    }
}
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int k = 3; k <= n; k++) {
            int max = k - 1;
            int limit = k >> 1;
            for (int i = 2; i <= limit; i++) {
                max = Math.max(i * (k - i), max);
                max = Math.max(dp[i] * (k - i), max);
                max = Math.max(i * dp[k - i], max);
                max = Math.max(dp[i] * dp[k - i], max);
            }
            dp[k] = max;
        }
        return dp[n];
    }
}
