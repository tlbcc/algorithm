package pers.tlbcc.algorithm.basic;

/**
 * @author tlbcc
 * @description 寻找全排列的下一个数
 * 例子：12345 -> 12354 -> 12435 ...
 * @date 2019-08-22 17:26
 */
public class NearestNumber {

    public static int[] findNearestNumber(int[] numbers) {
        // 查找逆序区间最左位置
        int index = findReverseIndex(numbers);
        // 逆序区间前一个数字交换与逆序区间中大于这个数的最小数字交换
        if (index == 0) {
            return null;
        }
        exchangeHead(numbers, index);
        // 逆序区间转正序
        reverse(numbers, index);
        return null;
    }

    private static int findReverseIndex(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static void exchangeHead(int[] numbers, int index) {
        for (int i = numbers.length - 1; i >= index; i--) {
            if (numbers[i] > numbers[index - 1]) {
                swap(numbers, i, index - 1);
                break;
            }
        }
    }

    private static void reverse(int[] numbers, int index) {
        for (int i = index, j = numbers.length - 1; i < j; i++, j--) {
            swap(numbers, i, j);
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            findNearestNumber(numbers);
            print(numbers);
        }
    }

    //test
    public static void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
}
