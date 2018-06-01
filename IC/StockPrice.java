public class StockPrice {
  public static int getMaxProfit(int[] arr) {
    int minPrice = arr[0];
    int maxProfit = arr[1] - minPrice;

    for (int i = 1; i < arr.length; i++) {
      int currentPrice = arr[i];
      int potentialProfit = currentPrice - minPrice;
      maxProfit = Math.max(maxProfit, potentialProfit);

      minPrice = Math.min(minPrice, currentPrice);
    }

    return maxProfit;
  }

  public static void main(String... args) {
    System.out.println(getMaxProfit(new int[] {10, 7, 5, 8, 11, 9}));
  }
}
