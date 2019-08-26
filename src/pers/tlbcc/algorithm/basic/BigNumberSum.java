package pers.tlbcc.algorithm.basic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author: tlbcc
 * @description: 大数相加
 * @date: 2019-08-26 17:21
 **/
public class BigNumberSum {

    public static String sum(String a, String b) {
        int aLangth = a.length() / 9 + 1;
        int bLangth = b.length() / 9 + 1;
        // 阶段性倒叙存储
        int[] numA = new int[aLangth];
        int[] numB = new int[bLangth];
        int[] sum = new int[Math.max(aLangth, bLangth) + 1];
        for (int i = 0; i < aLangth; i++) {
            int r = a.length() - i * 9;
            int l = r - 9 >= 0 ? r - 9 : 0;
            numA[i] = parse(a, l, r);
        }
        for (int i = 0; i < bLangth; i++) {
            int r = b.length() - i * 9;
            int l = r - 9 >= 0 ? r - 9 : 0;
            numB[i] = parse(b, l, r);
        }
        System.out.println(Arrays.toString(numA));
        System.out.println(Arrays.toString(numB));
        // add
        int carry = 0;
        for (int i = 0; i < sum.length; i++) {
            if (i < aLangth) {
                sum[i] += numA[i];
            }
            if (i < bLangth) {
                sum[i] += numB[i];
            }
            if (carry != 0) {
                sum[i] += carry;
                carry = 0;
            }
            if (sum[i] / 1_000_000_000 == 1) {
                carry = 1;
                sum[i] %= 1_000_000_000;
            }
        }
        System.out.println(Arrays.toString(sum));
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sum.length; i++) {
            int num = sum[i];
            for (int j = 0; j < 9; j++) {
                stack.push((char)(num % 10 + '0'));
                num /= 10;
            }
        }
        System.out.println(stack);
        boolean start = false;
        StringBuffer strb = new StringBuffer();
        while (!stack.empty()) {
            char c = stack.pop();
            if (c != '0') {
                start = true;
            }
            if (start) {
                strb.append(c);
            }
        }
        return strb.toString();
    }

    private static int parse(String num, int l, int r) {
        int a = 0;
        for (int i = l; i < r; i++) {
            a *= 10;
            a += num.charAt(i) - '0';
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(sum("1111111112222222223", "888888888999999999"));
        System.out.println(new BigInteger("1111111112222222223").add(new BigInteger("888888888999999999")).toString());
    }
}
