object Solution {
    def reverseWords(s: String): String = {
        s.split(" ").filterNot(_.isEmpty).reverse.mkString(" ")
    }
}
