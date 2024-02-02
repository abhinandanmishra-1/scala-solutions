import scala.collection.mutable

object Solution {
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        val mp = mutable.HashMap[String, List[String]]()
        for (word <- strs) {
            val count = Array.fill(26)(0)
            for (letter <- word) {
                val ind = letter - 'a'
                count(ind) += 1
            }
            val s = count.mkString("-")
            mp(s) = mp.getOrElse(s, Nil) :+ word
        }
        mp.values.toList
    }

}
