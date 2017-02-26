package com.leetcode;

import java.math.BigInteger;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Created by max on 17-2-8.
 */
public class P2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int[] items, boolean reverse) {
            ListNode tail = this;
            if (reverse) {
                val = items[items.length - 1];
                for (int i = items.length - 2; i > -1; tail = tail.next, i--) {
                    tail.next = new ListNode(items[i]);
                }
            } else {
                val = items[0];
                for (int i = 1; i < items.length; tail = tail.next, i++) {
                    tail.next = new ListNode(items[i]);
                }
            }
        }

//        ListNode(ListNode node) {
//            val = node.val;
//            next = node.next;
//        }
//
//        ListNode getTail() {
//            if (this.next == null) {
//                return this;
//            }
//            ListNode tail = null;
//            for (tail = this.next; tail.next != null; tail = tail.next) {
//
//            }
//            return tail;
//        }
//
//        ListNode add(ListNode node) {
//            getTail().next = new ListNode(node);
//            return this;
//        }
//
//        ListNode add(int item) {
//            getTail().next = new ListNode(item);
//            return this;
//        }

        int length() {
            int len = 0;
            for (ListNode tail = this; tail != null; tail = tail.next) {
                len++;
            }
            return len;
        }

        /**
         * No support for big integer.
         */
        @Deprecated
        int toInteger() {
            int len = length();
            int result = 0;
            ListNode tail = this;
            for (int i = 0; tail != null && i < len; tail = tail.next, i++) {
                result += tail.val * Math.pow(10, i);
            }
            return result;
        }

        void print() {
            for (ListNode tail = this; tail != null; tail = tail.next) {
                if (tail.next == null) {
                    System.out.print(tail.val + "\n");
                    break;
                }
                System.out.print(tail.val + " -> ");
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        l1 = new ListNode(new int[]{2, 4, 3}, false);

        l1.print();
        l2.print();

        System.out.println("l1 = " + Integer.toString(l1.toInteger()));
        System.out.println("l2 = " + Integer.toString(l2.toInteger()));
        System.out.println("l1 + l2 = " + Integer.toString(l1.toInteger() + l2.toInteger()));

        l1 = new ListNode(new int[] {2,4,3}, false);
        l2 = new ListNode(new int[] {5,6,4}, false);

        l1 = new ListNode(new int[]{9}, false);
        l2 = new ListNode(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9}, false);

        l1 = new ListNode(new int[]{2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9}, false);
        l2 = new ListNode(new int[]{5, 6, 4, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9, 9, 9, 9}, false);

        l1 = new ListNode(5);
        l2 = new ListNode(5);

        addTwoNumbers3(l1, l2).print();
    }

    @Deprecated
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] nodes = Integer.toString(l1.toInteger() + l2.toInteger()).chars().map(c -> c -= '0').toArray();
        return new ListNode(nodes, true);
    }

    @Deprecated
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int l1Len = 0, l2Len = 0;
        BigInteger l1Int = BigInteger.valueOf(0), l2Int = BigInteger.valueOf(0);

        // getLength

        for (ListNode tail = l1; tail != null; tail = tail.next) {
            l1Len++;
        }
        for (ListNode tail = l2; tail != null; tail = tail.next) {
            l2Len++;
        }

        // toInteger

        ListNode tail = l1;
        for (int i = 0; tail != null && i < l1Len; tail = tail.next, i++) {
            l1Int = l1Int.add(BigInteger.valueOf((long) (tail.val * Math.pow(10, i))));
        }

        tail = l2;
        for (int i = 0; tail != null && i < l2Len; tail = tail.next, i++) {
            l2Int = l2Int.add(BigInteger.valueOf((long) (tail.val * Math.pow(10, i))));
        }

        // construct l3 result

        int[] result = l1Int.add(l2Int).toString().chars().map(c -> c -= '0').toArray();

        ListNode l3 = new ListNode(result[result.length - 1]);
        tail = l3;
        for (int i = result.length - 2; i > -1; tail = tail.next, i--) {
            tail.next = new ListNode(result[i]);
        }

        return l3;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        int carry = 0;

        for (ListNode l1Tail = l1, l2Tail = l2, l3Tail = l3;
             l1Tail != null || l2Tail != null || carry > 0;
             l3Tail = l3Tail.next) {

            l3Tail.val = (l1Tail == null ? 0 : l1Tail.val) + (l2Tail == null ? 0 : l2Tail.val) + carry;

            if (l3Tail.val > 9) {
                carry = l3Tail.val / 10;
                l3Tail.val = l3Tail.val % 10;
            } else {
                carry = 0;
            }

            if (l1Tail != null && l1Tail.next != null) {
                l1Tail = l1Tail.next;
            } else {
                l1Tail = null;
            }

            if (l2Tail != null && l2Tail.next != null) {
                l2Tail = l2Tail.next;
            } else {
                l2Tail = null;
            }

            if (l1Tail != null || l2Tail != null || carry > 0) {
                l3Tail.next = new ListNode(0);
            }

        }
        return l3;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        int carry = 0;

        ListNode l1Tail = l1, l2Tail = l2, l3Tail = l3;

        while (l1Tail != null || l2Tail != null || carry > 0) {
            l3Tail.val = (l1Tail != null ? l1Tail.val : 0) + (l2Tail != null ? l2Tail.val : 0) + carry;
            carry = l3Tail.val / 10;
            l3Tail.val %= 10;

            if (l1Tail != null) {
                l1Tail = l1Tail.next;
            }

            if (l2Tail != null) {
                l2Tail = l2Tail.next;
            }

            if (l1Tail != null || l2Tail != null || carry > 0) {
                l3Tail.next = new ListNode(0);
                l3Tail = l3Tail.next;
            }
        }

        if (carry > 0) {
            l3Tail.next = new ListNode(carry);
        }

        return l3;
    }
}
