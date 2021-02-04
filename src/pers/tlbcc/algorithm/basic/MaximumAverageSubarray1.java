package pers.tlbcc.algorithm.basic;

import java.util.Objects;

/**
 * @author tlbcc
 * @description leetcode 643. 子数组最大平均数 I
 * @date 2021/2/4 16:35
 */
public class MaximumAverageSubarray1 {

    /**
     * leetcode 方法
     *
     * @param nums 整数数组
     * @param k    连续数个数
     * @return double
     * @author tlbcc
     * @date 2021/2/4 16:42
     **/
    public static double findMaxAverage(int[] nums, int k) {
        Objects.requireNonNull(nums);
        double max = Integer.MIN_VALUE;
        double sum = 0;
        // 首次
        for (int i = 0; i < k; i++) {
            sum += nums[i] / (double) k;
        }
        max = Math.max(max, sum);
        // 第二次开始
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] / (double) k + nums[i] / (double) k;
            max = Math.max(max, sum);
        }
        return max;
    }

    // 超出时间限制
    public static double findMaxAverage1(int[] nums, int k) {
        Objects.requireNonNull(nums);
        Objects.requireNonNull(k);
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j] / (double) k;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }

}
