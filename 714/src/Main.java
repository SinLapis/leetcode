public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
        int buy = -prices[0] - fee;
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int lastBuy = buy;
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, lastBuy + prices[i]);
        }
        return sell;
    }
}