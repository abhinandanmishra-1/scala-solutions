import scala.collection.mutable._
object Solution {
    def averageOfLevels(root: TreeNode): Array[Double] = {
        var queue = Queue[TreeNode]();

        queue.enqueue(root);
        var result = Array[Double]();

        while(queue.size>0) {
            var size = queue.size;

            var sum: Long = 0;
            for(_ <- 1 to size) {
                var top = queue.front;
                sum += top.value;

                if(top.left != null) {
                    queue.enqueue(top.left);
                }

                if(top.right != null) {
                    queue.enqueue(top.right)
                }

                queue.dequeue
            }

            result :+= (sum*1.0/size)
        }

        result
    }
}
