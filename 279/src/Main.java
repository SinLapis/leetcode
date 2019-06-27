public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(12));
    }
}
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int min;
        for (int i = 2; i <= n; i++) {
            min = dp[i - 1] + 1;
            for (int j = 1; j <= i; j++) {
                if (i < j * j) break;
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
