public class Solution {
    int maxValue; // use a global var to track the max value, make things much easier.
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    public int maxPathDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,maxPathDown(root.left));
        int right = Math.max(0,maxPathDown(root.right));
        maxValue = Math.max(maxValue, left + right + root.val);
        return Math.max(left,right) + root.val;
    }
}