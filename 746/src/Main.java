import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[] {0,0,1,1}));
    }
}
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        int twoStep = cost[0];
        int oneStep = cost[1];
        int current;
        for (int i = 2; i < cost.length; i++) {
            current = Math.min(twoStep + cost[i], oneStep + cost[i]);
            twoStep = oneStep;
            oneStep = current;
        }
        return Math.min(twoStep, oneStep);
    }
}