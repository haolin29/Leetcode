public class Solution {
	// inorder traversal, current val should alwasy larger than lastNodeVal.
	private int lastNodeVal = Integer.MIN_VALUE;
	private boolean firstNodeFlag = true;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}

		if (!firstNodeFlag && lastNodeVal >= root.val) {
			return false;
		}

		firstNodeFlag = false;
		lastNodeVal = root.val;
		if (!isValidBST(root.right)) {
			return false;
		}

		return true;

	}
}