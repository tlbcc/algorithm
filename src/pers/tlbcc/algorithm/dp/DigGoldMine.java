package pers.tlbcc.algorithm.dp;

/**
 * @author tlbcc
 * @description 10人挖5金矿，求最多挖多少
 * @date 2019-08-28 11:26
 **/
public class DigGoldMine {

    /**
     * 计算最好挖掘情况
     *从
     * @param n 各金矿价值, 各金矿所需人数
     * @param w 工人总数
     * @return
     */
    public static int count(int[][] n, int w) {
        int[][] p = new int[n.length + 1][w + 1];
        for (int i = 1; i <= n.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < n[i - 1][1]) {
                    p[i][j] = p[i - 1][j];
                } else {
                    p[i][j] = Math.max(p[i - 1][j], p[i - 1][j - n[i - 1][1]] + n[i - 1][0]);
                }
//                print(p);
            }
        }
        return p[n.length][w];
    }

    private static void print(int[][] p) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=================================== ");
    }
    
    public static void main(String[] args) {
        int[][] n = new int[][]{{400, 5}, {500, 5}, {200, 3}, {300, 4}, {350, 3}};
        System.out.println(count(n, 10));
    }

}
