public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumDeleteSum("eat", "sea"));
    }
}

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = dp[i][0] + c1[i];
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j + 1] = dp[0][j] + c2[j];
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (c1[i] == c2[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(
                            dp[i][j + 1] + c1[i],
                            dp[i + 1][j] + c2[j]
                    );
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}