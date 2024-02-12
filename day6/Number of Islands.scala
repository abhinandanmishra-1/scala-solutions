import scala.collection.mutable._

object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        var m = grid.size
        var n = grid(0).size

        def isGood(x: Int, y: Int): Boolean = {
            return x>=0 && x<m && y>=0 && y<n && grid(x)(y) == '1';
        }

        case class Tuple(row: Int, col: Int)
        var directions = Array[Tuple](
                Tuple(1, 0),
                Tuple(-1, 0),
                Tuple(0, 1),
                Tuple(0, -1)
        )

        def bfs(x: Int, y: Int): Unit = {
            var q = Queue[Tuple]()

            q.enqueue(Tuple(x, y))
            grid(x)(y) = '0'

            while(q.size > 0) {
                var top = q.dequeue
                var (curr_x, curr_y) = (top.row, top.col)

                for(dir <- directions) {
                    var next_x = dir.row + curr_x
                    var next_y = dir.col + curr_y

                    if(isGood(next_x, next_y)) {
                        grid(next_x)(next_y) = '0'
                        q.enqueue(Tuple(next_x, next_y))
                    }
                }
            }
        }

        var count = 0
        for(i <- 0 until m) {
            for(j <- 0 until n) {
                if(grid(i)(j) == '1') {
                    count += 1
                    bfs(i, j)
                }
            }
        }

        count
    }
}
