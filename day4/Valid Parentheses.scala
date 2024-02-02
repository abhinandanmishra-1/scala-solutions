object Solution {
  def isValid(s: String): Boolean = {
    val st = new scala.collection.mutable.Stack[Char]
    val mp = Map('}' -> '{', ')' -> '(', ']' -> '[')

    for (ch <- s) {
      if (mp.contains(ch)) {
        if (st.isEmpty || st.top != mp(ch)) return false
        st.pop()
      } else {
        st.push(ch)
      }
    }

    st.isEmpty
  }
}
