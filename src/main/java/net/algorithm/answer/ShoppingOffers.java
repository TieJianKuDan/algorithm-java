package net.algorithm.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/24 10:17
 * @Description 638. 大礼包
 * @Since version-1.0
 */
public class ShoppingOffers {
    public static void main(String[] args) {
        Integer[] priceArr = {2, 3, 4};
        Integer[][] specialArr = {{1, 1, 0, 4}, {2, 2, 1, 9}};
        Integer[] needsArr = {1, 2, 1};
        ArrayList<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(specialArr[0]));
        special.add(Arrays.asList(specialArr[1]));
        System.out.println(new ShoppingOffers().shoppingOffers(Arrays.asList(priceArr), special, Arrays.asList(needsArr)));
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 排除不合理的大礼包
        for (int i = 0; i < special.size();) {
            int sum = 0;
            for (int j = 0; j < price.size(); j++) {
                sum += special.get(i).get(j) * price.get(j);
            }
            if (sum <= special.get(i).get(price.size())) {
                special.remove(i);
            } else {
                i++;
            }
        }
        int res = dfs(price, special, needs, 0);
        return res;
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int money) {
        int size = needs.size();
        int res = Integer.MAX_VALUE;
        if (special.size() == 0) {
            int help = 0;
            for (int j = 0; j < size; j++) {
                help += needs.get(j) * price.get(j);
            }
            res = help;
        }
        for (int i = 0; i < special.size(); i++) {
            int[] temp = new int[size];
            boolean flag = true;
            for (int j = 0; j < size; j++) {
                temp[j] = needs.get(j) - special.get(i).get(j);
                if (temp[j] < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < size; j++) {
                    needs.set(j, temp[j]);
                }
                money += special.get(i).get(size);
                res = Math.min(res, dfs(price, special, needs, money));
                money -= special.get(i).get(size);
                for (int j = 0; j < size; j++) {
                    needs.set(j, temp[j] + special.get(i).get(j));
                }
            } else {
                int help = money;
                for (int j = 0; j < size; j++) {
                    help += needs.get(j) * price.get(j);
                }
                res = Math.min(res, help);
            }
        }
        return res;
    }
}
