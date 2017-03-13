package contest.weekly23;

/**
 * 541. Reverse String II My SubmissionsBack To Contest
 * https://leetcode.com/contest/leetcode-weekly-contest-23/problems/reverse-string-ii/
 *
 * Created by max on 17-3-12.
 */
public class P541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }

    public static String reverseStr(String s, int k) {
        int rawLength = s.length();

        if (rawLength < k) {
            StringBuilder sb = new StringBuilder(s);
            return sb.reverse().toString();
        }

        StringBuilder result = new StringBuilder();

        int loop = rawLength / (2 * k);
        int remain = rawLength % (2 * k);

        for (int i = 0; i < loop; i++) {
            String sub = s.substring(i * 2 * k, (i * 2 * k) + (2 * k - 1) + 1);
            StringBuilder sb = new StringBuilder(sub.substring(0, k));
            result.append(sb.reverse()).append(sub.substring(k, 2 * k));
        }

        if (remain < k) {
            StringBuilder sb = new StringBuilder(s.substring(loop * 2 * k, loop * 2 * k + remain));
            result.append(sb.reverse());
        } else if (remain >= k && remain < (2 * k)) {
            String sub = s.substring(loop * 2 * k, loop * 2 * k + remain);
            StringBuilder sb = new StringBuilder(sub.substring(0, k));
            result.append(sb.reverse()).append(sub.substring(k, remain));
        }

        return result.toString();
    }
}
