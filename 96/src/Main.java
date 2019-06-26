public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(4));
    }
}
class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int[] sum = new int[n + 1];
        sum[0] = 1;
        sum[1] = 1;
        sum[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum[i] += sum[j - 1] * sum[i - j];
            }
        }
        return sum[n];
    }
}
