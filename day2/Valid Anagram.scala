object Solution {
    def isAnagram(s: String, t: String): Boolean = {
        var sCounter = s.groupBy(identity).mapValues(_.length);
        var tCounter = t.groupBy(identity).mapValues(_.length);

        sCounter.toList == tCounter.toList;
    }
}
