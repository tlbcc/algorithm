package pers.tlbcc.algorithm.greedy;

/**
 * @author: tlbcc
 * @description: 删除K个数字后的最小值
 * @date: 2019-08-26 11:11
 **/
public class RemoveKNumber {

    public static String count(String num, int k) {
        int newLength = num.length() - k;
        char[] newNum = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && newNum[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            newNum[top++] = c;
        }
        int offset = 0;
        while (offset < newLength && newNum[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(newNum, offset, newLength - offset);
    }

    public static void main(String[] args) {
        String num = "541270936";
        System.out.println(count(num, 1));
        System.out.println(count(num, 2));
        System.out.println(count(num, 3));
        System.out.println(count("123456", 3));
    }
}
