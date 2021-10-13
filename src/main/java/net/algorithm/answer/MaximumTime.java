package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/24 11:37
 * @Description 1736. 替换隐藏数字得到的最晚时间
 * @Since version-1.0
 */
public class MaximumTime {
    public static void main(String[] args) {
        System.out.println(maximumTime("2?:?0"));
    }

    public static String maximumTime(String time) {
        char[] time_c = new char[4];
        time_c[0] = time.charAt(0);
        time_c[1] = time.charAt(1);
        time_c[2] = time.charAt(3);
        time_c[3] = time.charAt(4);
        StringBuilder stringBuilder = new StringBuilder();

        if ('?' == time_c[0]) {
            if (time_c[1] <= '3' || time_c[1] == '?') {
                time_c[0] = '2';
            } else {
                time_c[0] = '1';
            }
        }
        if ('?' == time_c[1]) {
            if (time_c[0] == '2') {
                time_c[1] = '3';
            } else {
                time_c[1] = '9';
            }
        }
        if ('?' == time_c[2]) {
            time_c[2] = '5';
        }
        if ('?' == time_c[3]) {
            time_c[3] = '9';
        }
        stringBuilder.append(time_c[0]);
        stringBuilder.append(time_c[1]);
        stringBuilder.append(':');
        stringBuilder.append(time_c[2]);
        stringBuilder.append(time_c[3]);
        return stringBuilder.toString();
    }
}
