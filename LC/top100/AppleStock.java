import java.util.*;

class AppleStock {
  public int maxProfit(int[] prices) {
    int N = prices.length;
    if (N < 2) throw new IllegalArgumentException();

    int minPrice = prices[0];
    int maxProfitSoFar = prices[1] - prices[0];
    for (int price: prices) {
      int profit = price - minPrice;
      maxProfitSoFar = Math.max(maxProfitSoFar, profit);
      minPrice = Math.min(price, minPrice);
    }
    return maxProfitSoFar;
  }
}
