object Solution {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val memo = Array.fill[Long](amount+1)(Int.MaxValue + 1)

    def findMinimumCoins(amountRemaining: Int): Long = {
      if (amountRemaining < 0) return Int.MaxValue
      if (amountRemaining == 0) return 0

      if (memo(amountRemaining) != Int.MaxValue + 1) {
        return memo(amountRemaining)
      }

      var minCoins: Long = Int.MaxValue
      for (coin <- coins) {
        val currCoins = 1 + findMinimumCoins(amountRemaining - coin)
        minCoins = Math.min(minCoins, currCoins)
      }

      memo(amountRemaining) = minCoins
      minCoins
    }

    findMinimumCoins(amount).toInt match {
      case Int.MaxValue => -1
      case result => result
    }
  }
}
