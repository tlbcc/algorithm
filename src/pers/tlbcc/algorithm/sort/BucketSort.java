package pers.tlbcc.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author tlbcc
 * @description 桶排序
 * @date 2019-08-16 17:36
 **/
public class BucketSort {

    public static void sort(double[] arr) {
        double max = arr[0];
        double min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        double bucketSize = (max - min) / (arr.length - 1);
        // 初始化桶
        ArrayList<LinkedList<Double>> buckets = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            buckets.add(new LinkedList<>());
        }
        // 分桶
        for (int i = 0; i < arr.length; i++) {
            int bucketNum = (int)((arr[i] - min) / bucketSize);
            buckets.get(bucketNum).add(arr[i]);
        }
        // 对每个桶内进行排序
        for (LinkedList<Double> list : buckets) {
            Collections.sort(list);
        }
        // 按顺序倒出桶内元素
        int index = 0;
        for (LinkedList<Double> list : buckets) {
            for (Double d : list) {
                arr[index++] = d;
            }
        }

    }

    // test
    public static double[] getRandomArr() {
        double[] arr = new double[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 100;
        }

        return arr;
    }

    // test
    public static void print(double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        double[] arr = getRandomArr();
        print(arr);
        sort(arr);
        print(arr);
    }
}
