
// travseral
public class Solution {
	private lastNode = null;
    public void flatten(TreeNode root) {
    	if (root == null) return;
    	if (lastNode != null) {
    		lastNode.left = null;
    		lastNode.right = root;
    	}

    	lastNode = root;
    	TreeNode right = root.right;
    	flatten(root.left);
    	flatten(right);
    }
}

// divide and conquer
// 
public class Solution {
	public void flatten(TreeNode root) {
		helper(root);
	}

	public TreeNode helper(TreeNode root) {
		if (root == null) return;

		if (root.left == null && root.right == null) {
			return root;
		}

		if (root.left == null) {
			return helper(root.right);
		}

		if (root.right == null) {
			root.right = root.left;
			root.left = null;
			return helper(root.right);
		}

		TreeNode leftLastNode = helper(root.left);
		TreeNode rightLastNode = helper(root.right);


		leftLastNode.right = root.right;
		root.right = root.left;
		root.left = null;
		return rightLastNode;
	}
}