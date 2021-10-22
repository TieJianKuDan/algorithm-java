package net.algorithm.answer;

import java.util.*;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/22 19:31
 * @Description 229. 求众数 II
 * @Since version-1.0
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 3, 1, 4, 5, 6};
        System.out.println(new MajorityElement().majorityElementPro(nums));
    }

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int threshold = len / 3;
        Map<Integer, Integer> map = new HashMap<>(len);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
            if (count > threshold) {
                set.add(num);
                map.remove(num);
            }
        }
        return new ArrayList<Integer>(set);
    }

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElementPro(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        // 根据题意应该最多只有两个数是答案，所以这里定义两个变量作为“席位”
        int seat1 = 0;
        int seat2 = 0;
        // 定义每个席位上的候选人所拥有的票数
        int count1 = 0;
        int count2 = 0;
        // 开始投票
        for (int num : nums) {
            if (count1 == 0 && seat2 != num) {
                seat1 = num;
                count1++;
            } else if (count2 == 0 && seat1 != num) {
                seat2 = num;
                count2++;
            } else if (seat1 == num) {
                count1++;
            } else if (seat2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        // 验证 seat1 和 seat2 是否的确是结果
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == seat1) {
                count1++;
            }
            if (num == seat2) {
                count2++;
            }
        }
        if (count1 > threshold) {
            result.add(seat1);
        }
        if (count2 > threshold && seat1 != seat2) {
            result.add(seat2);
        }
        return result;
    }
}
