import scala.collection.mutable._
object Solution {
    def longestConsecutive(nums: Array[Int]): Int = {
    var st = SortedSet(nums: _*)

    var ans = 0

    while (st.nonEmpty) {
      var start = st.head

      var count = 0
      while (st.nonEmpty && st.contains(start)) {
        count += 1
        st -= start
        start += 1
      }

      ans = ans max count
    }

    ans
  }
}
