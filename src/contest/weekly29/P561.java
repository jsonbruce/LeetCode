package contest.weekly29;

import java.util.Arrays;
import java.util.Collection;

/**
 * 561. Array Partition I
 * https://leetcode.com/contest/leetcode-weekly-contest-29/problems/array-partition-i/
 * <p>
 * Created by max on 17-4-23.
 */
public class P561 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2};

        System.out.println(arrayPairSum(nums));
    }

    /**
     * AC! (To be honest, I'm a little suprised)
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
