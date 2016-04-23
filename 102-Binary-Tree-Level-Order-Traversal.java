public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null) {
			return res;
		}

		queue.offer(root);
		while(!queue.isEmpty()) {
			
			List<Integer> level = new ArrayList<>();
			int n = queue.size();
			// level iteration
			for (int i = 0; i < n; i++) {
				TreeNode tmp = queue.poll();
				level.add(root.val);
				if (root.left != null) {
					queue.offer(tmp.left);
				}

				if (root.right != null) {
					queue.offer(tmp.right);
				}
			}
			
			res.add(level);
		}

		return res;
	}
}