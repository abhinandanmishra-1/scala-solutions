/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def sortedBst(nums: Array[Int], i: Int, j: Int): TreeNode = {
    if (i > j) return null
    val mid = i + (j - i) / 2
    val root = new TreeNode(nums(mid))
    root.left = sortedBst(nums, i, mid - 1)
    root.right = sortedBst(nums, mid + 1, j)
    root
  }

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    sortedBst(nums, 0, nums.length - 1)
  }
}
