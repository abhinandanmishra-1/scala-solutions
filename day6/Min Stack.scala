import scala.collection.mutable.Stack

class MinStack() {
  private val minSt: Stack[Int] = Stack()
  private val st: Stack[Int] = Stack()

  def push(value: Int): Unit = {
    val st2 = Stack[Int]()

    while (minSt.nonEmpty && minSt.top < value) {
      st2.push(minSt.top)
      minSt.pop()
    }

    minSt.push(value)

    while (st2.nonEmpty) {
      minSt.push(st2.top)
      st2.pop()
    }

    st.push(value)
  }

  def pop(): Unit = {
    val topValue = st.top
    st.pop()

    val st2 = Stack[Int]()
    while (minSt.top != topValue) {
      st2.push(minSt.top)
      minSt.pop()
    }

    minSt.pop()

    while (st2.nonEmpty) {
      minSt.push(st2.top)
      st2.pop()
    }
  }

  def top(): Int = st.top

  def getMin(): Int = minSt.top
}
