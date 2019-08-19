package pers.tlbcc.algorithm.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tlbcc
 * @description: 获取无序数组排序后的最大相邻差
 * @date: 2019-08-19 10:47
 **/
public class MaxSortDistance {

    public static int count(int[] arr) {
        List<Bucket> buckets = new ArrayList<>(arr.length);
        int max = arr[0];
        int min = arr[0];
        // 1.寻找最大最小值
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 2.初始化桶
        for (int i = 0; i < arr.length; i++) {
            buckets.add(new Bucket());
        }
        // 3.分桶
        for (int i = 0; i < arr.length; i++) {
            int bucketNum = (arr[i] - min) * (arr.length - 1) / (max - min);
            Bucket bucket = buckets.get(bucketNum);
            if (bucket.getMin() == null) {
                bucket.setMin(arr[i]);
                bucket.setMax(arr[i]);
                continue;
            }
            bucket.setMax(Math.max(bucket.getMax(), arr[i]));
            bucket.setMin(Math.min(bucket.getMin(), arr[i]));
        }
        // 4.查找最大值
        int maxDictance = Integer.MIN_VALUE;
        max = buckets.get(0).getMax();
        for (int i = 1; i < buckets.size(); i++) {
            if (buckets.get(i).getMin() == null) {
                continue;
            }
            min = buckets.get(i).getMin();
            maxDictance = Math.max(maxDictance, min - max);
            max = buckets.get(i).getMax();
        }
        return maxDictance;
    }

    public static class Bucket {
        private Integer max;
        private Integer min;

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }
    }

    // test
    public static int[] getRandomArr() {
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
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
        int result = count(arr);
        System.out.println(result);
    }
}
