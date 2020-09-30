package week4;

import utils.TreeNode;

public class Day3_SumOfLeftLeaves_DFS {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if (left != null && left.left == null && left.right == null)
            sum += left.val;
        return root;
    }
}
