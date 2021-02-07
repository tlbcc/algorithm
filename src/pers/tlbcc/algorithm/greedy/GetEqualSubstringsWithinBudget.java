package pers.tlbcc.algorithm.greedy;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tlbcc
 * @description leetcode 1208. 尽可能使字符串相等
 * @date 2021/2/5 14:13
 */
public class GetEqualSubstringsWithinBudget {

    /**
     * leetcode 提供的方法
     *
     * @param s       字符串s
     * @param t       字符串t
     * @param maxCost 最大开销，转换代价不能大域最大开销
     * @return int
     * @author tlbcc
     * @date 2021/2/5 14:14
     **/
    public static int equalSubstring(String s, String t, int maxCost) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        int useCost = 0;
        // 由于只取最大长度，所以左右指针之间的距离只会越来越大
        for (int l = 0, r = 0; r < arr.length; r++) {
            useCost += arr[r];
            // 判断代价，指针移动
            if (useCost > maxCost) {
                useCost -= arr[l];
                l++;
            } else {
                maxLength = Math.max(r - l + 1, maxLength);
            }
        }
        return maxLength;
    }

    /**
     * 暴力递归方式（对数器）
     *
     * @param s       s字符串
     * @param t       t字符串
     * @param maxCost 最大开销
     * @return int
     * @author tlbcc
     * @date 2021/2/5 17:20
     **/
    public static int equalSubstringGreedy(String s, String t, int maxCost) {
        int l1 = progress(s, t, maxCost, 0, 0, 0, true);
        int l2 = progress(s, t, maxCost, 0, 0, 0, false);
        return Math.max(l1, l2);
    }

    /**
     * @param s          字符串s
     * @param t          字符串t
     * @param maxCost    最大开销
     * @param index      字符串当前下标
     * @param useCost    已使用的开销
     * @param length     当前已转换长度
     * @param needChange 当前字符是否需要转换
     * @return int 最大长度
     * @author tlbcc
     * @date 2021/2/5 14:27
     **/
    public static int progress(String s, String t, int maxCost, int index, int useCost, int length, boolean needChange) {
        // 超过最大开销 或 字符串全部转换完毕 返回
        if (useCost > maxCost || index == s.length()) {
            return length;
        }
        if (needChange) {
            char cs = s.charAt(index);
            char ct = t.charAt(index);
            int cost = Math.abs(cs - ct) + useCost;
            if (cost > maxCost) {
                return length;
            }
            return progress(s, t, maxCost, index + 1, cost, length + 1, true);
        } else {
            int l1 = progress(s, t, maxCost, index + 1, useCost, 0, true);
            int l2 = progress(s, t, maxCost, index + 1, useCost, 0, false);
            return Math.max(l1, l2);
        }
    }

    public static void test(int testTime) {
        Random r = new Random();
        for (int i = 0; i < testTime; i++) {
            int length = r.nextInt(10);
            int cost = r.nextInt(10);
            String a = randomStr(length);
            String b = randomStr(length);
            int r1 = equalSubstring(a, b, cost);
            int r2 = equalSubstringGreedy(a, b, cost);
            if (r1 == r2) {
                continue;
            }
            int[] arr = new int[a.length()];
            for (int j = 0; j < a.length(); j++) {
                arr[j] = Math.abs(a.charAt(j) - b.charAt(j));
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("s: " + a);
            System.out.println("b: " + b);
            System.out.println("cost: " + cost);
            System.out.println("result-test: " + r1);
            System.out.println("result-right: " + r2);
            System.out.println("===================");
        }
    }


    // for test
    public static String randomStr(int length) {
        Random r = new Random();
        char[] arr = new char[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('a' + r.nextInt(5));
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        test(100);
    }

}
