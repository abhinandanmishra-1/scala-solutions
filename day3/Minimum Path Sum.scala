object Solution {
    def minPathSum(grid: Array[Array[Int]]): Int = {
        var rows = grid.size
        var cols = grid(0).size

        for(i <- 1 until cols) {
            grid(0)(i) += grid(0)(i-1);
        }

        for(i <- 1 until rows) {
            grid(i)(0) += grid(i-1)(0);
        }

        for(i <- 1 until rows) {
            for(j <- 1 until cols) {
                grid(i)(j) += Math.min(grid(i-1)(j), grid(i)(j-1));
            }
        } 

        grid(rows-1)(cols-1)
    }
}
