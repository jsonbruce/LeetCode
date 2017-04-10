package contest.weekly27;

import java.util.ArrayList;
import java.util.List;

/**
 * 557. Reverse Words in a String III
 * https://leetcode.com/contest/leetcode-weekly-contest-27/problems/reverse-words-in-a-string-iii/
 *
 * Created by max on 17-4-9.
 */
public class P557 {

    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        System.out.println(reverseWords(input).equals("s'teL ekat edoCteeL tsetnoc"));
    }

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        if (s.equals("")) {
            return "";
        }

        String[] words = s.split(" ");
        List<String> result = new ArrayList();

        for (String w : words) {
            result.add(new StringBuilder(w).reverse().toString());
        }

        StringBuilder sb = new StringBuilder("");
        for (String r : result) {
            sb.append(r).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
