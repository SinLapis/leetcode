public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minPathSum(new int[][] {
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}
        }));
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < m + n - 1; i++) {
            int y = 0, x = i;
            while (y < n) {
                if (x < m) {
                    if (x == 0) {
                        sum[0][y] = sum[0][y - 1] + grid[0][y];
                        break;
                    } else if (y == 0)
                        sum[x][0] = sum[x - 1][0] + grid[x][0];
                    else
                        sum[x][y] = Math.min(sum[x][y - 1], sum[x - 1][y]) + grid[x][y];
                }
                y++;
                x--;
            }
        }
        return sum[m - 1][n - 1];
    }
}
