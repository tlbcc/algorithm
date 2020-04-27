package pers.tlbcc.algorithm.basic;

/**
 * @author tlbcc
 * @description 有效的数独 leetcode 36
 * @date 2020-04-27 14:38
 */
public class ValidSudoku {

    /**
     * 2 ms
     * @param board 9 * 9 数独数组
     * @return 是否为有效数独
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        char dot = '.';
        char zero = '0';
        short checker = 0;
        // 检查行
        for (int i = 0; i < board.length; i++) {
            checker = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == dot) {
                    continue;
                }
                short a = (short) (1 << (board[i][j] - zero));
                short b = (short) (a & checker);
                if (b != 0) {
                    return false;
                }
                checker |= a;
            }
        }
        // 检查列
        for (int i = 0; i < board[0].length; i++) {
            checker = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == dot) {
                    continue;
                }
                short a = (short) (1 << (board[j][i] - zero));
                short b = (short) (a & checker);
                if (b != 0) {
                    return false;
                }
                checker |= a;
            }
        }
        // 检查九宫格
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                checker = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] == dot) {
                            continue;
                        }
                        short a = (short) (1 << (board[i + k][j + l] - zero));
                        short b = (short) (a & checker);
                        if (b != 0) {
                            return false;
                        }
                        checker |= a;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
