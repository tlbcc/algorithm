package pers.tlbcc.algorithm.dp;

/**
 * @author tlbcc
 * @description 不同的二叉搜索树 leetcode 96
 * @date 2020-07-15 10:50
 */
public class DifferentBinarySearchTree {

    /**
     * 0ms ???
     * dp
     */
    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - 1 - j];
            }
        }
        return arr[n];
    }

    /**
     * 太慢了<br>
     * 解题思路（来自评论）：
     * 假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，
     * 其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     */
    public static int numTrees1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numTrees1(i) * numTrees1(n - 1 - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
    }
}
