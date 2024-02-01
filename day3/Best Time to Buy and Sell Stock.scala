object Solution {
    def maxProfit(prices: Array[Int]): Int = {
        var maximumProfit = 0;
        var prevMinimumPrice = prices(0)

        for(price <- prices) {
            maximumProfit = Math.max(maximumProfit, price - prevMinimumPrice)
            prevMinimumPrice = Math.min(prevMinimumPrice, price)
        }

        maximumProfit
    }
}
