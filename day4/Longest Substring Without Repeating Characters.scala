import scala.collection.mutable._
object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        var counter = Map[Char, Int]().withDefaultValue(0)

        var start = 0
        var end = 0
        var len = 0
        while(end < s.length) {
            if(counter(s(end)) == 1) {
                while(start<end && counter(s(end)) == 1) {
                    counter(s(start)) -= 1
                    start+=1
                }
            }

            counter(s(end)) += 1;
            end+=1;

            len = Math.max(len, end - start);
        }

        len
    }
}
