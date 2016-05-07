public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }

    public List<TreeNode> helper(int start, int end) {
    	List<TreeNode> list = new ArrayList<>();

    	if (start > end) {
    		list.add(null);
    		return list;
    	}

    	if (start == end) {
    		list.add(new TreeNode(end));
    		return list;
    	}

    	List<TreeNode> left, right;

    	for (int i = start; i <= end; i++) {
    		left = helper(start, i - 1);
    		right = helper(i+1, end);
    		for (TreeNode lnode:left) {
    			for (TreeNode rnode:right ) {
    				TreeNode root = new TreeNode(i);
    				root.left = lnode;
    				root.right = rnode;
    				list.add(root);
    			}
    		}
    	}

    	return list;
    }
}