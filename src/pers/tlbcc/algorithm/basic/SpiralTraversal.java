package pers.tlbcc.algorithm.basic;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tlbcc
 * @description 螺旋遍历
 * @date 2020-09-21 10:40
 */
public class SpiralTraversal {

    private static int[][] createArr() {
        Random r = new Random();
        // 矩阵行数
        int m = r.nextInt(10) + 1;
//        int m = 7;
        // 矩阵列数
        int n = r.nextInt(10) + 1;
//        int n = 5;
        int[][] arr = new int[n][m];
        // 填充数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(100);
            }
        }
        // 打印数组
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        return arr;
    }

    private static void count(int[][] arr) {
        // 矩阵行数
        int m = arr.length;
        // 矩阵列数
        int n = arr[0].length;
        // 遍历多少圈
        for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
            // 上（左 --> 右）
            for (int j = i; j < n - i; j++) {
                System.out.print(arr[i][j]);
                System.out.print(", ");
            }
//            System.out.println();
            // 右（上 --> 下）
            for (int j = i + 1; j < m - i; j++) {
                System.out.print(arr[j][n - i - 1]);
                System.out.print(", ");
            }
//            System.out.println();
            // 下（右 --> 左）
            for (int j = i + 1; j < n - i && i < m - i - 1; j++) {
                System.out.print(arr[m - i - 1][n - j - 1]);
                System.out.print(", ");
            }
//            System.out.println();
            // 左（下 --> 上）
            for (int j = i + 1; j < m - i - 1 && m - j - 1 < n - i - 1; j++) {
                System.out.print(arr[m - j - 1][i]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = createArr();
        count(arr);
    }

}
