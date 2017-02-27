package com.leetcode;

import java.util.List;
import java.util.LinkedList;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/?tab=Description
 * <p>
 * Created by max on 17-2-27.
 */
public class P5 {

    public static void main(String[] args) {
        List<String> testCases = new LinkedList<>();
        testCases.add("babad");
        testCases.add("cbbd");
//        testCases.add("a");
//        testCases.add("");
//        testCases.add(null);
//        testCases.add("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");

        for (String s : testCases) {
            System.out.println("Input: " + s);
            System.out.println("Output: " + longestPalindrome1(s) + "\n");
        }
    }

    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        String pal = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && (sub.length() > pal.length())) {
                    pal = sub;
                }
            }
        }
        return pal;
    }

    static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public static String longestPalindrome1(String T) {
        if (T == null) {
            return null;
        }
        String result = null;
        //存放最大回文字符串的长度
        int max = 0;
        //遍历每一个字符，以每一个字符为中心判断奇偶扩展子串
        for (int i = 0; i < T.length(); i++) {
            //定义两个数组下标指针，以i，i+1为中心的偶子序列
            int pStart = i;
            int pEnd = i + 1;
            while (pStart >= 0 && pEnd <= (T.length() - 1) && T.charAt(pStart) == T.charAt(pEnd)) {
                pStart--;
                pEnd++;
            }
            //如果子字符串的长度>max，则暂存为最长子回文串 子回文串的长度=(pEnd-1)-(pStart+1)-1=pEnd-pStart-1
            if (pEnd - pStart - 1 > max) {
                max = pEnd - pStart - 1;
                result = T.substring(pStart + 1, pEnd - 1 + 1);
            }

            //以i为中心，判断扩展奇序列是否为回文串
            pStart = i - 1;
            pEnd = i + 1;
            while (pStart >= 0 && pEnd <= (T.length() - 1) && T.charAt(pStart) == T.charAt(pEnd)) {
                pStart--;
                pEnd++;
            }
            if (pEnd - pStart - 1 > max) {
                max = pEnd - pStart - 1;
                result = T.substring(pStart + 1, pEnd - 1 + 1);
            }
        }
        return result;
    }

}
