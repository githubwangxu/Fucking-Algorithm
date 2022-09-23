package leetcode.L121;

public class MaxProfit {
  public int maxProfit(int[] prices) {
    int buyPrice = Integer.MAX_VALUE, sealPrice = Integer.MIN_VALUE, profit = 0;

    for (int price : prices) {
      if (sealPrice < price) {
        sealPrice = price;
      }
      if (buyPrice > price) {
        buyPrice = price;
        sealPrice = price;
      }
      profit = Math.max(sealPrice - buyPrice, profit);
    }
    return profit;
  }
}
