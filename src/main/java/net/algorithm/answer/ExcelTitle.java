package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/30 10:35
 * @Description 171. Excel 表列序号
 * @Since version-1.0
 */
public class ExcelTitle {
    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }

    public static int titleToNumber(String columnTitle) {
        int res = 0;
        int mod = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            res += ((int) columnTitle.charAt(i) - 64) * mod;
            mod *= 26;
        }
        return res;
    }
}
