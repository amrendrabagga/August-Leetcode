package week4;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Day3_SumOfLeftLeafs_BFS {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return sum;
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(root, false));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.isLeft && p.node.left == null && p.node.right == null) {
                sum += p.node.val;
            }
            if (p.node.left != null) {
                queue.offer(new Pair(p.node.left, true));
            }
            if (p.node.right != null) {
                queue.offer(new Pair(p.node.right, false));
            }
        }
        return sum;
    }
    static class Pair {
        boolean isLeft;
        TreeNode node;
        Pair(TreeNode node, boolean isLeft) {
            this.node = node;
            this.isLeft = isLeft;
        }
    }
}
