package pers.tlbcc.algorithm.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: tlbcc
 * @description: 快速排序（非递归版）
 * @date: 2019-08-14 16:30
 **/
public class QuickSortStack {

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
        Stack<Tag> stack = new Stack<>();
        stack.push(new Tag(0, arr.length - 1));
//        sort(arr, 0, arr.length - 1);
        while (!stack.empty()) {
            Tag tag = stack.pop();
            sort(stack, arr, tag.getL(), tag.getR());
        }
    }

    public static void sort(Stack<Tag> stack, int[] arr, int l, int r) {
        if (l > r) {
            return;
        }

        int random = (int)(Math.random() * (r - l + 1)) + l;
        swap(arr, r, random);
        int p = partition(arr, l, r);

        stack.push(new Tag(p + 1, r));
        stack.push(new Tag(l, p - 1));
//        sort(arr, l, p - 1);
//        sort(arr, p + 1, r);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static class Tag {
        private int l;
        private int r;

        public Tag(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public int getL() {
            return l;
        }

        public void setL(int l) {
            this.l = l;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        @Override
        public String toString() {
            return "Tag{" +
                    "l=" + l +
                    ", r=" + r +
                    '}';
        }
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
