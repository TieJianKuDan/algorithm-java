package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/9 9:57
 * @Description 794. 有效的井字游戏
 * @Since version-1.0
 */
public class ValidTicTacToe {
    public static void main(String[] args) {
        ValidTicTacToe self = new ValidTicTacToe();
        System.out.println(self.validTicTacToe(new String[]{"XXX","   ","OOO"}));
    }

    public boolean validTicTacToe(String[] board) {
        int xcount = 0;
        int ocount = 0;
        for (String s : board) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'O') {
                    ocount++;
                }
                if (s.charAt(i) == 'X') {
                    xcount++;
                }
            }
        }
        if (xcount < ocount || xcount - 1 > ocount) {
            return false;
        }
        if (ocount >= 3 && xcount >= 3) {
            int xLine = 0;
            int oLine = 0;
            for (String s : board) {
                if (s == "OOO") {
                    oLine++;
                }
                if (s == "XXX") {
                    xLine++;
                }
            }
            if (xLine + oLine > 1) {
                return false;
            }
            for (int i = 0; i < 3; i++) {
                if ("" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i) == "OOO") {
                    oLine++;
                }
                if ("" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i) == "XXX") {
                    xLine++;
                }
            }
            if (xLine + oLine > 1) {
                return false;
            }
            if ("" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2) == "OOO" ||
                    "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0) == "OOO") {
                oLine++;
            }
            if ("" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2) == "XXX" ||
                    "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0) == "XXX") {
                xLine++;
            }
            if (xLine + oLine > 1) {
                return false;
            }
        }
        return true;
    }
}
