package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/18 21:55
 * @Description 419. 甲板上的战舰
 * @Since version-1.0
 */
public class CountBattleships {
    public static void main(String[] args) {

    }

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    spread(board, i, j);
                }
            }
        }
        return count;
    }
    public void spread(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length
                || j < 0
                || j >= board[0].length
                || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        spread(board, i - 1, j);
        spread(board, i + 1, j);
        spread(board, i, j + 1);
        spread(board, i, j - 1);
    }
}
