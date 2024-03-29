/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * trait NestedInteger {
 *
 *   // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *   def isInteger: Boolean
 *
 *   // Return the single integer that this NestedInteger holds, if it holds a single integer.
 *   def getInteger: Int
 *
 *   // Set this NestedInteger to hold a single integer.
 *   def setInteger(i: Int): Unit
 *
 *   // Return the nested list that this NestedInteger holds, if it holds a nested list.
 *   def getList: Array[NestedInteger]
 *
 *   // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *   def add(ni: NestedInteger): Unit
 * }
 */

class NestedIterator(_nestedList: List[NestedInteger]) {
    var arr = Array[Int]()
    var index = 0

    def initialize(list: Array[NestedInteger], curr: Int = 0): Unit = {
        if(curr >= list.size) return

        if(list(curr).isInteger) {
            arr :+= list(curr).getInteger
        }else {
            initialize(list(curr).getList, 0)
        }

        initialize(list, curr + 1)
    }

    initialize(_nestedList.toArray)

    def next(): Int = {
        index += 1
        arr(index-1)
    }
    
    def hasNext(): Boolean = {
        index < arr.length
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = new NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
