package pers.tlbcc.algorithm.sort;

import java.util.Arrays;

/**
 * @author: tlbcc
 * @description: 堆排序
 * @date: 2019-08-13 10:28
 **/
public class HeapSort {

    public static void down(int arr[], int n, int length) {
        int parentIndex = n;
        int childIndex = 2 * parentIndex + 1;
        int temp = arr[parentIndex];

        while (childIndex < length) {
            if (childIndex + 1 < length && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++;
            }

            if (temp >= arr[childIndex]) {
                break;
            }

            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        arr[parentIndex] = temp;

    }

    public static void buildHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            down(arr, i, arr.length);
        }
    }

    public static void sort(int[] arr) {
        // 构建而二叉堆，升序建大根堆，降序建小根堆
        buildHeap(arr);
        // 交换对顶元素，调整堆
        for (int i = arr.length - 1; i > 0 ; i--) {
            swap(arr, 0, i);
            down(arr, 0, i);
        }
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
