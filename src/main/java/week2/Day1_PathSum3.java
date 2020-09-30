package week2;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Day1_PathSum3 {
    private int count = 0;
    List<Integer> list = new ArrayList<>();
    public int pathSum(TreeNode root, int sum) {
        getSum(root, sum);
        return count;
    }
    private void getSum(TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        getSum(root.left, sum);
        getSum(root.right, sum);

        int tmp = 0;
        for (int i = list.size() - 1; i>=0; i--) {
            tmp += list.get(i);
            if (tmp == sum)
                count++;
        }
        list.remove(list.size()-1);
    }

    /*
    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

            10
            /  \
            5   -3
            / \    \
            3   2   11
            / \   \
            3  -2   1

    Return 3. The paths that sum to 8 are:

            1.  5 -> 3
            2.  5 -> 2 -> 1
            3. -3 -> 11
    */
}
