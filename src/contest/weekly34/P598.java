package contest.weekly34;

/**
 * 598. Range Addition II
 * https://leetcode.com/contest/leetcode-weekly-contest-34/problems/range-addition-ii/
 * <p>
 * Created by max on 17-5-28.
 */
public class P598 {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2,2},{3,3}};
        int result = maxCount(m, n, ops);
        System.out.println(result);
    }

    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length <= 0) {
            return m * n;
        }

        int minX = ops[0][0];
        int minY = ops[0][1];
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] < minX) {
                minX = ops[i][0];
            }
            if (ops[i][1] < minY) {
                minY = ops[i][1];
            }
        }

        return minX * minY;
    }
}
