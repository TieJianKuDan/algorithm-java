package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/13 15:14
 * @Description 520. 检测大写字母
 * @Since version-1.0
 */
public class DetectCapital {
    public static void main(String[] args) {

    }

    public boolean detectCapitalUse(String word) {
        int length = word.length();
        if (length <= 1) {
            return true;
        }
        boolean isUp = false;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            isUp = true;
        }
        if (isUp) {
            isUp = false;
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                isUp = true;
            }
            if (isUp) {
                for (int i = 2; i < length; i++) {
                    char temp = word.charAt(i);
                    if (temp >= 'a' && temp <= 'z') {
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < length; i++) {
                    char temp = word.charAt(i);
                    if (temp >= 'A' && temp <= 'Z') {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 1; i < length; i++) {
                char temp = word.charAt(i);
                if (temp >= 'A' && temp <= 'Z') {
                    return false;
                }
            }
        }
        return true;
    }
}
