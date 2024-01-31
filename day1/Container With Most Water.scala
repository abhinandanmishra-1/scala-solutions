import scala.collection.mutable.Stack 
object Solution {
    def maxArea(heights: Array[Int]): Int = {
        var start = 0;
        var end = heights.length - 1;
        var area = 0;

        while(start<end) {
            var length = end - start;
            var height = Math.min(heights(start), heights(end));
            var currentArea = length*height;
            area = Math.max(area, currentArea);

            if(heights(start)<heights(end)) start+=1;
            else end-=1;
        }

        return area;
    }
}
