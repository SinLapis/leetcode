public class Main {
}
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int twoStep = nums[0];
        int oneStep = Math.max(nums[0], nums[1]);
        int current;
        for (int i = 2; i < nums.length; i++) {
            current = Math.max(oneStep, twoStep + nums[i]);
            twoStep = oneStep;
            oneStep = current;
        }
        return Math.max(twoStep, oneStep);
    }
}
