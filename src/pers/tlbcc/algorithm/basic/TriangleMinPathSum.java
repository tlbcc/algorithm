package pers.tlbcc.algorithm.basic;

import java.util.Arrays;
import java.util.List;

/**
 * @author tlbcc
 * @description 三角形最小路径和 leetcode 120
 * @date 2020-07-14 11:20
 */
public class TriangleMinPathSum {

    /**
     * 2 ms
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] arr = new int[triangle.size()];
        List<Integer> list = triangle.get(triangle.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                arr[j] = list.get(j) + Math.min(arr[j], arr[j + 1]);
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        List<Integer> a1 = Arrays.asList(2);
        List<Integer> a2 = Arrays.asList(3, 4);
        List<Integer> a3 = Arrays.asList(6, 5, 7);
        List<Integer> a4 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> a = Arrays.asList(a1, a2, a3, a4);
        System.out.println(a.toString());
        System.out.println(minimumTotal(a));
    }
}
