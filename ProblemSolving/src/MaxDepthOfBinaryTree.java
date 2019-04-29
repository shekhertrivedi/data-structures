
public class MaxDepthOfBinaryTree {

	public static void main(String[] args) {

	}
	
	public int maxDepth(TreeNode root) {
		
		if(root == null) return 0;
		if(root.left != null && root.right != null) {
			return 1;
		}
		
		return Math.max(1 + maxDepth(root.left), 1+maxDepth(root.right));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}