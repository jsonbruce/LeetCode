package test;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result;

        result = twoSum(nums, target);

        System.out.println("[" + Integer.toString(result[0]) + ", " + Integer.toString(result[1]) + "]");
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] resutl = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resutl[0] = i;
                    resutl[1] = j;
                    return resutl;
                }
            }
        }
        return resutl;
    }
}
