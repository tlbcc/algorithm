package pers.tlbcc.algorithm.basic;

import java.util.Stack;

/**
 * @author tlbcc
 * @description 用栈实现一个队列
 * @date 2019-08-21 11:10
 **/
public class StackQueue {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    public void in(Integer n) {
        stackA.push(n);
    }

    public Integer out() {
        synchronized (stackA) {
            if (stackB.empty()) {
                while (!stackA.empty()) {
                    stackB.push(stackA.pop());
                }
            }
            if (stackB.empty()) {
                return null;
            }
        }
        return stackB.pop();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        for (int i = 0; i < 10; i++) {
            in(queue);
        }


        for (int i = 0; i < 5; i++) {
            out(queue);
        }

        for (int i = 0; i < 5; i++) {
            in(queue);
            out(queue);
        }

        for (int i = 0; i < 5; i++) {
            out(queue);
        }


    }

    // test
    public static void in(StackQueue queue) {
        int random = (int) (Math.random() * 100);
        System.out.println("in queue: " + random);
        queue.in(random);
    }

    // test
    public static void out(StackQueue queue) {
        System.out.println("out queue: " + queue.out());
    }
}
