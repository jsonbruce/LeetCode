package contest.weekly21;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum My SubmissionsBack To Contest
 * https://leetcode.com/contest/leetcode-weekly-contest-21/problems/continuous-subarray-sum/
 *
 * Created by max on 17-2-26.
 */
public class P523 {

    public static void main(String[] args) {
        Map<int[], Integer> testCases = new HashMap<>();
        testCases.put(new int[] {23, 2, 4, 6, 7}, 6);
        testCases.put(new int[] {23, 2, 6, 4, 7}, 6);
        testCases.put(new int[] {23, 2, 6, 4, 7}, 0);
        testCases.put(new int[] {1, 2, 3}, 4);
        testCases.put(new int[] {0, 0}, 0);

        for (HashMap.Entry<int[], Integer> entry : testCases.entrySet()) {
            System.out.println("Input: " + array2String(entry.getKey()) + ", k=" + entry.getValue());
            System.out.println("Output: " + checkSubarraySum(entry.getKey(), entry.getValue()));
        }
    }

    static String array2String(int[] datas) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < datas.length; i++) {
            if (i == 0) {
                sb.append("[" + datas[i] + ", ");
                continue;
            }
            if (i == datas.length-1) {
                sb.append(datas[i] + "]");
                continue;
            }
            sb.append(datas[i] + ", ");
        }
        return sb.toString();
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];

                if (k == 0 && sum == 0) {
                    return true;
                } else if (k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
