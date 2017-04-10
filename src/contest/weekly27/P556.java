package contest.weekly27;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 556. Next Greater Element III
 * https://leetcode.com/contest/leetcode-weekly-contest-27/problems/next-greater-element-iii/
 *
 * Created by max on 17-4-9.
 */
public class P556 {

    public static void main(String[] args) {
        nextGreaterElement(Integer.MAX_VALUE);
    }

    /**
     * 12345 -> 12354
     * 12354 < Integer.MAX_VALUE
     *
     * @param n
     * @return
     */
    public static int nextGreaterElement(int n) {
        int[] digits = toDigitsIntArray(n);

        int first = digits[0];
        for (int d : digits) {
            System.out.println(d);
        }


        return 0;
    }

    static byte[] toDigitsByteArray(int n) {
        String ns = Integer.toString(n);
        byte[] digits = new byte[ns.length()];
        for (int i = 0; i < ns.length(); i++) {
            digits[i] = (byte) (ns.charAt(i) - '0');
        }

        return digits;
    }

    static int[] toDigitsIntArray(int n) {
        return Integer.toString(n).chars().map(c -> c - '0').toArray();
    }

    static int toInt(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int d : digits) {
            sb.append(d);
        }
        return Integer.parseInt(sb.toString());
    }

}
