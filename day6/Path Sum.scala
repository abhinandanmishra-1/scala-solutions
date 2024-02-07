/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
        def isPathSum(root: TreeNode, curr: Int = 0): Boolean = {
            if(root == null) return false;

            var next = curr + root.value;
            if(root.left == null && root.right == null && next == targetSum) return true; 

            isPathSum(root.left, next) || isPathSum(root.right, next) 
        }

        isPathSum(root)
    }
}
