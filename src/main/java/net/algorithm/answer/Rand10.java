package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/5 9:54
 * @Description 470. 用 Rand7() 实现 Rand10()
 * @Since version-1.0
 */
public class Rand10 {
    public static void main(String[] args) {

    }

    public int rand10() {
        while (true) {
            int temp = rand7();
            // 1 - 5
            if (temp > 4) {
                while (true) {
                    temp = rand7();
                    if (temp <= 5) {
                        return temp;
                    }
                }
            }
            // 6 - 10
            if (temp < 4) {
                while (true) {
                    temp = rand7();
                    if (temp <= 5) {
                        return temp + 5;
                    }
                }
            }
        }
    }

    public int rand7() {
        return 0;
    }
}
