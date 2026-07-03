class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        int l = 0;
        for(int r = 1; r < n;r++) {
            int profit = prices[r] - prices[l];
            max = Math.max(max, profit);
            if(prices[l] > prices[r]) {
                l = r;
            }
        }
        return max;
    }
}
