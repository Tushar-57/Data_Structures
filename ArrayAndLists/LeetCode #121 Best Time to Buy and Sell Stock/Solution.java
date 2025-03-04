class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update minPrice to the lower of the current price and the minPrice so far.
            minPrice = Math.min(minPrice, price);
            // Calculate potential profit if selling at the current price.
            int currentProfit = price - minPrice;
            // Update maxProfit if the current profit is higher.
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
}
