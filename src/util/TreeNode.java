package util;

/**
 * Binary Tree structure.
 * used for BST etc.
 *
 * Created by max on 17-2-26.
 */
public class TreeNode<T> {
    T val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(T x) {
        val = x;
    }

    TreeNode(Object v, TreeNode l, TreeNode r) {
        val = (T) v;
        left = l;
        right = r;
    }

    /**
     * Build tree with Level Ordered data array.
     *
     * @param datas
     * @param rootIndex
     * @return
     */
    TreeNode buildTree(Object[] datas, int rootIndex) {
        if (datas.length == 0) {
            return null;
        }

        if (rootIndex < datas.length && datas[rootIndex] != null) {
            int leftIndex = rootIndex * 2 + 1;
            int rightIndex = rootIndex * 2 + 2;

            return new TreeNode(datas[rootIndex], buildTree(datas, leftIndex), buildTree(datas, rightIndex));
        } else {
            return null;
        }
    }
}
