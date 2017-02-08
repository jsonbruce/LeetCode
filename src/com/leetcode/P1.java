package com.leetcode;

import java.util.*;

/**
 * Created by max on 17-2-7.
 */
public class P1 {
    public static void main(String[] args) {
        Map<Object, Integer> datasets = new HashMap<>();
        datasets.put(new int[]{2, 7, 11, 15}, 9);  // return [0, 1]
        datasets.put(new int[]{3, 2, 4}, 6);   // [1,2]
        datasets.put(new int[]{3, 3}, 6);   // [0,1]
        datasets.put(new int[]{2,5,5,11}, 10); // [1,2]

        for (Map.Entry<Object, Integer> entry : datasets.entrySet()) {
            int[] result = twoSum2((int[]) entry.getKey(), entry.getValue());
            System.out.printf("[%d, %d]\n", result[0], result[1]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] resutl = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resutl[0] = i;
                    resutl[1] = j;
                    return resutl;    // return new int[] {i, j};
                }
            }
        }
        return resutl;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);   // the same key will be override
        }
        for (int i = 0; i < nums.length; i++) {      // although numsMap lost the whole index->value, but nums can refer
            int complement = target - nums[i];
            if (numsMap.containsKey(complement) && numsMap.get(complement) != i) {
                return new int[]{i, numsMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                return new int[]{i, numsMap.get(complement)};
            }
            numsMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
