package contest.weekly23;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by max on 17-3-12.
 */
public class P536 {

    public static void main(String[] args) {
        List<String> cases = new ArrayList<>();
        cases.add("4(2(3)(1))(6(5))");

        for (String s : cases) {
            TreeNode root = str2tree(s);
            root.levelOrder();
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        void levelOrder() {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    System.out.print(cur.val + " -> ");
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
            }
        }
    }

    /**
     * Awesome Java Recursive Solution
     * https://discuss.leetcode.com/topic/82572/java-recursive-solution
     *
     * @param s
     * @return
     */
    static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));

        TreeNode cur = new TreeNode(val);

        if (firstParen == -1) {
            return cur;
        }

        int start = firstParen, leftParenCount = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftParenCount++;
            } else if (s.charAt(i) == ')') {
                leftParenCount--;
            }

            if (leftParenCount == 0 && start == firstParen) {
                cur.left = str2tree(s.substring(start + 1, i));
                start = i + 1;
            } else if (leftParenCount == 0) {
                cur.right = str2tree(s.substring(start + 1, i));
            }
        }

        return cur;
    }

    public static TreeNode str2treeTry(String s) {
        if (s.length() == 0 || s == null) {
            return null;
        }

        if (s.length() == 1) {
            TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, 1)));
            return root;
        }

        String leftTree = null;
        String rightTree = null;

        int leftParenthesis = 0;
        int rightParenthesis = 0;
        for (int i = 1, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '(') {
                leftParenthesis++;
            } else if (s.charAt(i) == ')') {
                rightParenthesis++;

                if (i + 1 < len && s.charAt(i + 1) == '(' && leftParenthesis == rightParenthesis) {
                    leftTree = s.substring(2, i);
                    rightTree = s.substring(i + 2, len - 1);
                    break;
                }
            }
        }

        if (leftParenthesis == 2) {

        }

        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, 1)));
        TreeNode lp = root, rp = root;
        for (int i = 2, len = s.length(); i < len; i += 2) {
            char prev = s.charAt(i - 1);
            char next = s.charAt(i + 1);

            if (prev == '(' && next == '(') {
                lp.left = new TreeNode(Integer.parseInt(s.substring(i, i + 1)));
                lp = lp.left;
            } else if (prev == '(' && next == ')') {
                lp.left = new TreeNode(Integer.parseInt(s.substring(i, i + 1)));
            }
        }


        TreeNode l = str2treeTry(leftTree);
        TreeNode r = str2treeTry(rightTree);


        return null;

    }

    static TreeNode helper(TreeNode root, TreeNode left, TreeNode right) {
        root.left = left;
        root.right = right;
        return root;
    }
}
