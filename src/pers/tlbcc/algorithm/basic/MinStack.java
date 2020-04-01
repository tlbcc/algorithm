package pers.tlbcc.algorithm.basic;

import java.util.Stack;

/**
 * @author tlbcc
 * @description 最小栈实现<br>
 * 一个栈，实现入栈，出栈，和获取当前栈内最小值。
 * @date 2019-08-16 14:07
 **/
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 出栈方法
     */
    public Integer pop() {
        Integer pop = stack.pop();
        if (pop == getMin()) {
            minStack.pop();
        }
        return pop;
    }

    /**
     * 入栈方法
     * @param num 入栈的整数
     */
    public void push(Integer num) {
        stack.push(num);
        if (minStack.empty() || (getMin() != null && num < getMin())) {
            minStack.push(num);
        }
    }

    /**
     * 获取栈中最小的数
     * @return
     */
    public Integer getMin() {
        if (minStack.empty()) {
            return null;
        }

        return minStack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(16);
        minStack.push(9);
        minStack.push(3);
        minStack.push(17);
        minStack.push(15);
        minStack.push(5);

        minStack.print();
        System.out.println();
        System.out.println("stack min: " + minStack.getMin());
        while (!minStack.empty()) {
            System.out.println("stack pop:" + minStack.pop());
            System.out.println("stack min: " + minStack.getMin());
            minStack.print();
            System.out.println();
        }

    }

    // test
    public void print() {
        System.out.print("stack: [ ");
        for (Integer i : stack) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

}
