package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2022/2/21 10:09
 * @Description 838. 推多米诺
 * @Since version-1.0
 */
public class Dominoes {
    public static void main(String[] args) {
        Dominoes self = new Dominoes();
        System.out.println(self.pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        int len = dominoes.length();

        if (len == 1) {
            return dominoes;
        }

        char[] oldStr = dominoes.toCharArray();
        char[] newStr = new char[len];
        boolean isFirst = true;
        boolean[] isComplete = new boolean[len];
        Arrays.fill(isComplete, false);

        while (true) {
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (newStr[i] != oldStr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            }
            if (!isFirst) {
                for (int i = 0; i < len; i++) {
                    oldStr[i] = newStr[i];
                }
            } else {
                isFirst = false;
            }

            for (int i = 0; i < len; i++) {
                if (isComplete[i]) {
                    continue;
                }
                char temp = oldStr[i];
                if (temp == 'R') {
//                    if (i + 1 >= len || oldStr[i + 1] != 'L') {
                        newStr[i] = 'R';
                        isComplete[i] = true;
//                    } else {
//                        newStr[i] = '.';
//                    }
                } else if (temp == 'L') {
//                    if (i - 1 <= 0 || oldStr[i - 1] != 'R') {
                        newStr[i] = 'L';
                        isComplete[i] = true;
//                    } else {
//                        newStr[i] = '.';
//                    }
                } else if (temp == '.') {
                    if (i - 1 < 0) {
                        if (oldStr[i + 1] == 'L') {
                            newStr[i] = 'L';
                            isComplete[i] = true;
                        } else {
                            newStr[i] = '.';
                        }
                    } else if (i + 1 >= len) {
                        if (oldStr[i - 1] == 'R') {
                            newStr[i] = 'R';
                            isComplete[i] = true;
                        } else {
                            newStr[i] = '.';
                        }
                    } else {
                        if (oldStr[i - 1] == 'R' && oldStr[i + 1] != 'L') {
                            newStr[i] = 'R';
                            isComplete[i] = true;
                        } else if (oldStr[i + 1] == 'L' && oldStr[i - 1] != 'R') {
                            newStr[i] = 'L';
                            isComplete[i] = true;
                        } else {
                            newStr[i] = '.';
                        }
                    }
                }
            }
        }

        return new String(newStr);
    }
}
