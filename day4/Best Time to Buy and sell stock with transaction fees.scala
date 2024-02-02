object Solution {
    var dp :Array[Array[Long]] = _
    def maxAns(prices: Array[Int], fee: Int, currInd: Int, buy: Boolean): Long = {
        if (currInd >= prices.length) return 0

        var buyIndex = if (buy) 1 else 0;
        if (dp(currInd)(buyIndex) != -1) return dp(currInd)(buyIndex)

        var ans: Long = 0
        if (buy) {
          // bought
          ans = -prices(currInd) - fee + maxAns(prices, fee, currInd + 1, false)
          // not bought
          ans = ans max maxAns(prices, fee, currInd + 1, true)
          } else {
          // sold
          ans = prices(currInd) + maxAns(prices, fee, currInd + 1, true)
          // not sold
          ans = ans max maxAns(prices, fee, currInd + 1, false)
        }

        dp(currInd)(buyIndex) = ans.toInt
        ans
    }

    def maxProfit(prices: Array[Int], fee: Int): Int = {
        dp = Array.fill(prices.length + 1, 2)(-1L)

        maxAns(prices, fee, 0, true).toInt
    }
}
