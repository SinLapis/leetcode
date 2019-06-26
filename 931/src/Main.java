public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minFallingPathSum(
                new int[][] {
                        new int[] {1,2,3},
                        new int[] {4,5,6},
                        new int[] {7,8,9}
                }
        ));
    }
}

class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0][0];
        int[][] sum = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            sum[0][i] = A[0][i];
        }
        int min = 0;
        for (int i = 1; i < A.length; i++) {
            sum[i][0] = Math.min(sum[i - 1][0], sum[i - 1][1]) + A[i][0];
            min = sum[i][0];
            for (int j = 1; j < A.length - 1; j++) {
                sum[i][j] = Math.min(sum[i - 1][j - 1], sum[i - 1][j]);
                sum[i][j] = Math.min(sum[i][j], sum[i - 1][j + 1]) + A[i][j];
                if (sum[i][j] < min) min = sum[i][j];
            }
            sum[i][A.length - 1] = Math.min(sum[i - 1][A.length - 2], sum[i - 1][A.length - 1]) + A[i][A.length - 1];
            if (sum[i][A.length - 1] < min) min = sum[i][A.length - 1];
        }
        return min;
    }
}
