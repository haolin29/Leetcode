public class Solution {
	public int kthSmallest(TreeNode root, int k) {
		int count = countNode(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1){
			return kthSmallest(root.right, k - 1 - count);
		}

		return root.val;
	}

	public int countNode(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return countNode(root.left) + countNode(root.right) + 1;
	}


// use a stack to memorize
// 
// 	
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		// inorder traverse using stack
		while (k != 0) {
			TreeNode node = stack.pop();
			k--;
			if (k == 0) return node.val;
			TreeNode right = node.right;
			while(right != null) {
				stack.push(right);
				right = right.left;
			}

		}
		return -1;
	}



}
