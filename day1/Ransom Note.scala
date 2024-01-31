import scala.collection.mutable._
object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
        var magazineCounter = magazine.groupBy(identity).mapValues(_.length).to(Map)

        for(ch <- ransomNote) {
            if(!magazineCounter.contains(ch) || magazineCounter(ch) == 0) return false;
            magazineCounter(ch) -= 1;
        }

        return true;
    }
}
