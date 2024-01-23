package slidingWindow;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] prices = new int[] { 7, 6, 4, 3, 1 };
        System.out.println("ANSWER = " + maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0, left = 0, right = 0;
        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                if (prices[right] - prices[left] > maxProfit) {
                    maxProfit = prices[right] - prices[left];
                }
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
