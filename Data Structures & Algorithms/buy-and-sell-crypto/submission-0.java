class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while(r < n) {
            if(prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
                r++;
            }else{
                l = r;
                r = l + 1;
            }
        }
        return maxProfit;
    }
}
