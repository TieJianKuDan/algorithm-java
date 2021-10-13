package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/22 10:50
 * @Description 789. 逃脱阻碍者
 * @Since version-1.0
 */
public class EscapeGhosts {
    public static void main(String[] args) {

    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int temp = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (temp <= distance) {
                return false;
            }
        }
        return true;
    }
}
