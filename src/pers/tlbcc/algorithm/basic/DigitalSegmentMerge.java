package pers.tlbcc.algorithm.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author tlbcc
 * @description 合并数字段，例如，合并前： 2, 10, 7, 1-3, 4-5, 6, 9-11 合并后：1-7, 9-11
 * @date 2020/3/3 18:26
 */
public class DigitalSegmentMerge {

    private static final String SEPARATOR = "-";

    private static void sort(List<String> list) {
        list.sort((o1, o2) -> {
            String o1_l = o1.split(SEPARATOR)[0];
            String o2_l = o2.split(SEPARATOR)[0];
            return Integer.parseInt(o1_l) - Integer.parseInt(o2_l);
        });
        System.out.println(list.toString());
    }

    private static void merge(List<String> list) {
        ArrayList resultList = new ArrayList<String>();
        String[] strs = list.get(0).split(SEPARATOR);
        int left = Integer.parseInt(strs[0]);
        int right = strs.length == 2 ? Integer.parseInt(strs[1]) : left;

        for (int i = 1; i < list.size(); i++) {
            strs = list.get(i).split(SEPARATOR);
            int l = Integer.parseInt(strs[0]);
            int r = strs.length == 2 ? Integer.parseInt(strs[1]) : l;
            if (l <= right + 1) {
                right = Math.max(r, right);
            } else {
                resultList.add(left + SEPARATOR + right);
                left = l;
                right = r;
            }
        }
        resultList.add(left + SEPARATOR + right);
        System.out.println(resultList.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        List list = Arrays.stream(str.split(",")).map(String::trim).collect(Collectors.toList());
        sort(list);
        merge(list);
    }

}
