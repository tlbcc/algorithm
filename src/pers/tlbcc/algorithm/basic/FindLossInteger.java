package pers.tlbcc.algorithm.basic;

import java.io.File;
import java.util.Arrays;

/**
 * @author: tlbcc
 * @description: 寻找缺失整数<br />
 * 一个数组中存放的都是正整数，其中有2个整数出现了奇数次，
 * 其他数都出现了偶数次，请找出这两个奇数。
 * @date: 2019/11/26 15:53
 */
public class FindLossInteger {

    public static void count(int[] arr) {
        int[] result = new int[2];
        int xofNumber = 0;
        // 找出两个数的异或结果
        for (int i = 0; i < arr.length; i++) {
            xofNumber ^= arr[i];
        }
        // 找出两个数的不同位，从而分治
        int separator = 1;
        while (0 == (xofNumber & separator)) {
            separator <<= 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (0 == (separator & arr[i])) {
                result[0] ^= arr[i];
            } else {
                result[1] ^= arr[i];
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 2, 5, 1, 4, 3};
        count(arr);
    }
}
