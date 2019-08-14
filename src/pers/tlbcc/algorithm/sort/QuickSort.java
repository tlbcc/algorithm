package pers.tlbcc.algorithm.sort;

import java.util.Arrays;

/**
 * @author: tlbcc
 * @description: 快速排序
 * @date: 2019-08-13 10:30
 **/
public class QuickSort {

    public static int partition(int[] arr, int l, int r) {
        int less = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[r]) {
                swap(arr, ++less, i);
            }
        }
        swap(arr, ++less, r);
        return less;
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }

        int random = (int)(Math.random() * (r - l + 1)) + l;
        swap(arr, r, random);
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // test
    public static int[] getRandomArr() {
        int[] arr = new int[30];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }

        return arr;
    }

    // test
    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = getRandomArr();
        print(arr);
        sort(arr);
        print(arr);
    }
}
