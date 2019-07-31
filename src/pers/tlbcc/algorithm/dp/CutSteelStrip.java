package pers.tlbcc.algorithm.dp;

import java.util.Arrays;

/**
 * @author: tlbcc
 * @description: 钢条切割
 * @date: 2019-07-31 17:39
 **/
public class CutSteelStrip {

    public static int cut(int[] p, int n) {
        int[] pMax = new int[n + 1];
        pMax[0] = 0;
        pMax[1] = 1;

        for (int i = 2; i <= n; i++) {
            int max = p[i - 1];
            for (int j = 1; j < i; j++) {
                max = Math.max(max, pMax[j] + pMax[i - j]);
            }
            pMax[i] = max;
        }
        printArr(pMax);
        return pMax[n];
    }

    public static void main(String[] args) {
        int[] p = new int[] { 1, 5, 8, 9, 10, 17, 17, 24, 30 };
        int n = 4;
        int maxValue = cut(p, n);
        System.out.println(maxValue);
    }

    // test
    private static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
