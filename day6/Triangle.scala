object Solution {
    def minimumTotal(triangle: List[List[Int]]): Int = {
        var rows = triangle.size
        var dp = Array[Int]()

        for(col <- 0 until triangle(rows-1).size) {
            dp :+= triangle(rows - 1)(col)
        } 

        for(row <- rows-2 to 0 by -1) {
            var cols = triangle(row).size

            for(col <- 0 until cols) {
                var value = Math.min(dp(col), dp(col+1));

                dp(col) = triangle(row)(col) + value
            }
        }

       dp(0)
    }
}
