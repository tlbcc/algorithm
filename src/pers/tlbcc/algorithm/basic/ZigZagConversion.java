package pers.tlbcc.algorithm.basic;


import java.util.Scanner;

/**
 * @author tlbcc
 * @description Z字形变换-leetcode-6
 * @date 2020-04-23 15:46
 */
public class ZigZagConversion {
    /**
     * 4ms
     * @param s 带转换字符串
     * @param numRows z字形行数
     * @return z转换后的字符串
     */
    public static String convert(String s, int numRows) {
        // 校验参数
        if (s == null || s.length() == 0 || numRows < 1) {
            return "";
        }
        // numRows为1，输出为源字符串
        if (numRows == 1) {
            return s;
        }
        StringBuilder strb = new StringBuilder();
        int index;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length() / (numRows - 1) + 1; j++) {
                // 找到字符下标
                if ((j & 1) == 0) {
//                    index = (j + 1) * numRows - j - (numRows - i);
                    index = j * (numRows - 1) + i;
                } else {
                    if (i == 0 || i == numRows - 1) {
                        continue;
                    }
//                    index = (j + 1) * numRows - (j + 1) - i;
                    index = (j + 1) * (numRows - 1) - i;
                }
                // 判断下标是否越界
                if (index >= s.length()) {
                    break;
                }
                // 拼接字符串
//                System.out.println("i: " + i + ", j: " + j + ", char: " + s.charAt(index));
                strb.append(s.charAt(index));
            }
        }
        return strb.toString();
    }

    /**
     * 3ms
     * @param s 带转换字符串
     * @param numRows z字形行数
     * @return z转换后的字符串
     */
    public static String convert1(String s, int numRows) {
        // 校验参数
        if (s == null || s.length() == 0 || numRows < 1) {
            return "";
        }
        // numRows为1，输出为源字符串
        if (numRows == 1) {
            return s;
        }
        char[] chars = new char[s.length()];
        int charIndex = 0;
        int index;
        int step = 2 * (numRows - 1);
        int length = chars.length / (numRows - 1) + 1;
        // 首行
        for (int i = 0; i < chars.length; i+= step) {
            chars[charIndex++] = s.charAt(i);
        }
        // 中间行
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 0; j < length + 1; j++) {
                // 找到字符下标
                if ((j & 1) == 0) {
                    index = j * (numRows - 1) + i;
                } else {
                    index = (j + 1) * (numRows - 1) - i;
                }
                // 判断下标是否越界
                if (index >= s.length()) {
                    break;
                }
                chars[charIndex++] = s.charAt(index);
            }
        }
        // 尾行
        for (int i = numRows - 1; i < chars.length; i += step) {
            chars[charIndex++] = s.charAt(i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int numRows = in.nextInt();
        String result = convert(s, numRows);
        System.out.println("result: " + result);
    }
}
