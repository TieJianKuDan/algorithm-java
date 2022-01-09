package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2022/1/9 9:51
 * @Description 1629. 按键持续时间最长的键
 * @Since version-1.0
 */
public class SlowestKey {
    public static void main(String[] args) {

    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longest = releaseTimes[0];
        char res = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time == longest) {
                res = keysPressed.charAt(i) > res ? keysPressed.charAt(i) : res;
            } else if (time > longest) {
                res = keysPressed.charAt(i);
                longest = time;
            }
        }

        return res;
    }
}
