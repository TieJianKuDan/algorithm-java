package net.algorithm.answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/8 9:53
 * @Description 299. 猜数字游戏
 * @Since version-1.0
 */
public class BullsCows {
    public static void main(String[] args) {

    }

    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                Integer num = map.getOrDefault(secret.charAt(i), 0);
                map.put(secret.charAt(i), num + 1);
                list.add(guess.charAt(i));
            }
        }
        for (Character c : list) {
            if (map.containsKey(c) && map.get(c) > 0) {
                b++;
                map.put(c, map.get(c) - 1);
            }
        }
        return a + "A" + b + "B";
    }
}
