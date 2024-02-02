import scala.collection.mutable._

class Trie {
  val children: Map[Char, Trie] = Map()
  var isWord: Boolean = false

  def insert(s: String): Unit = {
    var current = this
    for (c <- s) {
      if (!current.children.contains(c)) {
        current.children(c) = new Trie()
      }
      current = current.children(c)
    }
    current.isWord = true
  }

  def search(s: String): Boolean = {
    var current = this
    for (c <- s) {
      if (!current.children.contains(c)) {
        return false
      }
      current = current.children(c)
    }
    current.isWord
  }
}

object Solution {
    var trie: Trie = _
    var dp: Array[Int] = _
    def isPossible(s: String, start: Int): Boolean = {
        if(start >= s.length) return true

        var end = s.length - 1

        if(dp(start) != -1) return dp(start) == 1;

        var curr = ""
        for(i <- start to end) {
            curr += s(i)

            if(trie.search(curr) && isPossible(s, i+1)) {
                dp(start) = 1
                return true
            }
        }

        dp(start) = 0;
        false
    }
    
    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        trie = new Trie()
        dp = Array.fill(s.length+1)(-1)

        for(word <- wordDict) {
            trie.insert(word)
        }

        isPossible(s, 0)
    }
}
