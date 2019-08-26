package pers.tlbcc.algorithm.greedy;

/**
 * @author: tlbcc
 * @description: 删除K个数字后的最小值
 * @date: 2019-08-26 11:11
 **/
public class RemoveKNumber {

    public static String count(String num, int k) {
        for (int i = 0; i < k; i++) {
            num = remove(num);
        }
        return num;
    }

    private static String remove(String num) {
        int max = num.charAt(0);
        boolean hasCut = false;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) < max) {
                num = num.substring(0, i - 1) + num.substring(i);
                hasCut = true;
                break;
            }
            max = num.charAt(i);
        }
        if (!hasCut) {
            return num.substring(0, num.length() - 1);
        }
        return num;
    }

    public static void main(String[] args) {
        String num = "541270936";
        System.out.println(count(num, 1));
        System.out.println(count(num, 2));
        System.out.println(count(num, 3));
        System.out.println(count("123456", 3));
    }
}
