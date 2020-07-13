package pers.tlbcc.algorithm.basic;

import java.util.Arrays;
import java.util.List;

/**
 * @author tlbcc
 * @description 两数交集 leetcode 350
 * @date 2020-07-13 14:03
 */
public class IntersectionOfTwoNum {

    /**
     * 2ms
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0;
        int r = 0;
        int k = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] < nums2[r]) {
                l++;
            } else if (nums1[l] > nums2[r]) {
                r++;
            } else {
                nums1[k++] = nums1[l];
                l++;
                r++;
            }
        }
        return Arrays.copyOf(nums1, k);
    }

    public static void main(String[] args) {
        test3();
    }

    public static void print(int[] result) {
        System.out.println(Arrays.toString(result));
    }

    public static void print(List<Integer> result) {
        System.out.println(result.toString());
    }

    public static void test1() {
        int[] a = new int[]{1, 2, 2, 1};
        int[] b = new int[]{2, 2};
        System.out.println(Arrays.toString(intersect(a, b)));
    }

    public static void test2() {
        int[] a = new int[]{4, 9, 5};
        int[] b = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(a, b)));
    }

    public static void test3() {
        int[] a = new int[]{1, 2, 2, 1};
        int[] b = new int[]{2};
        System.out.println(Arrays.toString(intersect(a, b)));
    }
}
