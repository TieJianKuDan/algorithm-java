package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/19 14:44
 * @Description 997. 找到小镇的法官
 * @Since version-1.0
 */
public class FindJudge {
    public static void main(String[] args) {

    }

    public int findJudge(int n, int[][] trust) {
        int[] records = new int[n + 1];
        int candidate = -1;
        for (int i = 0; i < trust.length; i++) {
            records[trust[i][0]] = -1;
            if (records[trust[i][1]] == -1) {
                continue;
            }
            records[trust[i][1]]++;
        }
        for (int i = 1; i < records.length; i++) {
            if (records[i] == n - 1 && candidate != -1) {
                candidate = -1;
                break;
            }
            if (records[i] == n - 1) {
                candidate = i;
            }
        }
        return candidate;
    }
}
