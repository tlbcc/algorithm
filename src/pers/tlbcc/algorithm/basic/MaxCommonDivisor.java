package pers.tlbcc.algorithm.basic;

/**
 * @author: tlbcc
 * @description: 求两个正整数的最大公约数
 * @date: 2019-08-16 14:55
 **/
public class MaxCommonDivisor {

    /**
     * 计算两个正整数的最大公倍数
     * @param a 正整数a
     * @param b 正整数b
     * @return 最大公约数
     */
    public static int count(int a, int b) {
        if (a == b) {
            return a;
        }

        if ((a & 1) == 0 && (b & 1) == 0) {
            // 若a，b都是偶数
            return count(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) == 1) {
            // 若a偶，b奇
            return count(a >> 1, b);
        } else if ((a & 1) == 1 && (b & 1) == 0) {
            // 若a奇，b偶
            return count(a, b >> 1);
        } else {
            // 若a，b都是奇数
            return count(Math.min(a, b), Math.abs(a - b));
        }
    }

    public static void main(String[] args) {
        System.out.println(count(1000, 5000));
        System.out.println(count(1000, 5));
        System.out.println(count(56, 28));
        System.out.println(count(123454321, 11111));
        System.out.println(count(453051, 579120));
    }
}
