package pers.tlbcc.algorithm.basic;

/**
 * @author: tlbcc
 * @description: 判断一个正整数是否为2的整数次幂
 * @date: 2019-08-16 17:08
 **/
public class PowerOf2 {

    public static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2((int) Math.pow(2, 15)));
        System.out.println(isPowerOf2(1024));
        System.out.println(isPowerOf2(2049));
        System.out.println(isPowerOf2(1));
    }
}
