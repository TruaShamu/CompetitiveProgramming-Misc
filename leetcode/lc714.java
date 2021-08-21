class Solution {
    public int maxProfit(int[] prices, int fee) {
       int total = 0;
       if(prices.length > 0) {
           int min = prices[0];
           int max = prices[0];
           for(int i = 1; i < prices.length; ++i) {
              if(prices[i] < min || max - fee > prices[i]) {
                total += Math.max(0, max - min -fee);
                min = prices[i];
                max = prices[i];
              }  else {
                  max = Math.max(max, prices[i]);
              }
           }
           total += Math.max(0, max - min - fee);
       }

        return total;
    }
}
