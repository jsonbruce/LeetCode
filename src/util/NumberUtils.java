package util;

import java.util.Arrays;

/**
 * Created by max on 17-4-10.
 */
public class NumberUtils {

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
