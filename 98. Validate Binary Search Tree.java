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

// divide and conquer 

public class Solution {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, min, max) {
		if (root == null) return true;

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
}