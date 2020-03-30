package pers.tlbcc.algorithm.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: tlbcc
 * @description: 随机红包算法
 * 红包满足如下要求：
 * 1. 所有人抢到的金额总和等于红包金额
 * 2. 每人至少抢到0.01元
 * 3. 要保证每个金额尽量均衡分布，不要出现两极分化过于严重的情况
 * @date: 2020-03-30 16:22
 */
public class RandomRedEnvelope {

    /**
     * 划分红包金额
     * @param totalAmount 总金额（单位：分）
     * @param totalPeople 总人数
     * @return 划分好金额的List，长度为totalPeople
     */
    public static List<Integer> divideRedEnvelope(Integer totalAmount, int totalPeople) {
        int realAmount = totalAmount;
        int realNumber = totalPeople;
        List<Integer> list = new ArrayList<>(totalPeople);
        Random random = new Random();
        for (int i = 0; i < totalPeople - 1; i++) {
            // 随机范围[1, 剩余金额 / 剩余人数 * 2 - 1)
            int amount = random.nextInt(realAmount / realNumber * 2 - 1);
            list.add(amount);
            realAmount -= amount;
            realNumber--;
        }
        list.add(realAmount);
        return list;
    }

    public static void main(String[] args) {
        Double amount = 99.99;
        int people = 10;
        List<Integer> list = divideRedEnvelope((int)(amount * 100), 5);
        for (Integer i : list) {
            System.out.println(new BigDecimal(i).divide(new BigDecimal(100)));
        }
    }

}
