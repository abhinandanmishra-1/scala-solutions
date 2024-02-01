import scala.collection.mutable._
object Solution {
    def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
        var mp = Map[Int, Int]().withDefaultValue(-1)

        for(i <- 0 until nums.length) {
            var prevIndex = mp(nums(i));

            if(prevIndex == -1) {
                mp(nums(i)) = i;
            }else {
                var diff = i - prevIndex;
                mp(nums(i)) = i;
                if(diff<=k) return true;
            }
            
        }

        false;
    }
}
