public class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// nodes along the longest path from the root node down to the farthest leaf node.
		// one path
		return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
	}
}