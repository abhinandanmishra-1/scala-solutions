object Solution {
    def maxDepth(root: TreeNode): Int = {
      if(root == null) return 0;
    
      var left = maxDepth(root.left);
      var right = maxDepth(root.right);

      Math.max(left, right)+1;
    }
}
