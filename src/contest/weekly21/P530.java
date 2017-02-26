package contest.weekly21;

import java.util.List;
import java.util.LinkedList;

/**
 * 530. Minimum Absolute Difference in BST
 * https://leetcode.com/contest/leetcode-weekly-contest-21/problems/minimum-absolute-difference-in-bst/
 * <p>
 * Created by max on 17-2-26.
 */
public class P530 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        TreeNode(Object v, TreeNode l, TreeNode r) {
            val = (int) v;
            left = l;
            right = r;
        }

        static TreeNode buildTree(Object[] datas, int index) {
            if (datas.length == 0) {
                return null;
            }

            if (index < datas.length && datas[index] != null) {
                int leftIndex = index * 2 + 1;
                int rightIndex = index * 2 + 2;

                return new TreeNode(datas[index], buildTree(datas, leftIndex), buildTree(datas, rightIndex));
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Object[] datas = new Object[]{1, null, 2, 3};
        datas = new Object[]{543, 384, 652, null, 445, null, 699};
        TreeNode root = TreeNode.buildTree(datas, 0);
        System.out.printf("min = %d \n", getMinimumDifference(root));
    }

    static List<Integer> data = new LinkedList<Integer>();

    public static int getMinimumDifference(TreeNode root) {
        inOrder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0, len = data.size(); i < len - 1; i++) {
            int tmp = data.get(i + 1) - data.get(i);
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            data.add(root.val);
            inOrder(root.right);
        }
    }
}
