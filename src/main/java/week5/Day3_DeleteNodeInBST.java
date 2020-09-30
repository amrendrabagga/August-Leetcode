package week5;

import utils.TreeNode;

public class Day3_DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            root.val = findNextSuccessor(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    private int findNextSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}
