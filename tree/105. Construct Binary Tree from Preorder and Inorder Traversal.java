public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    	if (inStart > inEnd) return null;

    	TreeNode root = new TreeNode(preorder[preStart]);
    	int pos = findRootPosition(inorder, inStart, inEnd, preorder[preStart]);


    	root.left = helper(preorder, preStart + 1, preStart + pos - inStart, inorder, inStart, pos - 1);

    	root.right = helper(preorder, preEnd - (inEnd - pos) + 1, preEnd, inorder, pos + 1, inEnd);

    	return root;
    }

    public int findRootPosition(int[] inorder, int inStart, int inEnd, int key) {
    	int i;
    	for (i = inStart; i <= inEnd; i++) {
    		if (inorder[i] == key) {
    			return i;
    		}
    	}

    	return -1;
    }
}