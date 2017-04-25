package contest.weekly29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 562. Longest Line of Consecutive One in Matrix
 * https://leetcode.com/contest/leetcode-weekly-contest-29/problems/longest-line-of-consecutive-one-in-matrix/
 * <p>
 * Created by max on 17-4-23.
 */
public class P562 {

    public static void main(String[] args) {
        int[][] M = new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};
        M = new int[][] {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};

        System.out.println(longestLine(M));
    }

    /**
     * Wrong Answser. (not consider the consecutive)
     * @param M
     * @return
     */
    public static int longestLine(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        List<List<Integer>> rowIndexs = new ArrayList<>(Collections.nCopies(M.length, null));
        List<List<Integer>> colIndexs = new ArrayList<>(Collections.nCopies(M[0].length, null));

        // 1. [rowIndex->{colIndex}]
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    if (rowIndexs.isEmpty() || rowIndexs.get(i) == null) {
                        List<Integer> cols = new ArrayList<>();
                        cols.add(j);
                        rowIndexs.add(i, cols);
                    } else {
                        rowIndexs.get(i).add(j);
                    }

                    if (colIndexs.isEmpty() || colIndexs.get(j) == null) {
                        List<Integer> rows = new ArrayList<>();
                        rows.add(i);
                        colIndexs.add(j, rows);
                    } else {
                        colIndexs.get(j).add(i);
                    }
                }
            }
        }

        // 2.
        int resutl = 0;

        // Scan row
        for (int i = 0; i < rowIndexs.size(); i++) {
            List<Integer> cols = rowIndexs.get(i);
            if (cols != null && cols.size() > resutl) {
                resutl = cols.size();
                System.out.println(i + ", " + cols.toString());
            }
        }

        // Scan col
        for (List rows : colIndexs) {
            if (rows != null && rows.size() > resutl) {
                resutl = rows.size();
            }
        }

        // Scan diagonal (i, j) -> (i+1, j-1)
        // Scan anti-diagonal (i, j) -> (i+1, j+1)
        for (int i = 0; i < rowIndexs.size(); i++) {
            int len = 1;

            List<Integer> cols = rowIndexs.get(i);
            if (cols != null) {
                for (int j = 0; j < cols.size(); j++) {
                    if (rowIndexs.get(i + 1) != null && rowIndexs.get(i + 1).contains(j + 1)) {
                        len++;
                    }
                }

                if (len > resutl) {
                    resutl = len;
                }
            }
        }


        return resutl;
    }
}
