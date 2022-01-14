package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2022/1/14 11:01
 * @Description 373. 查找和最小的K对数字(没做完)
 * @Since version-1.0
 */
public class KSmallestPairs {
    public static void main(String[] args) {
        KSmallestPairs self = new KSmallestPairs();
        System.out.println(self.kSmallestPairs(new int[]{1, 2, 4}, new int[]{-1, 1, 2}, 100));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> res = new ArrayList<>(k);
        int p1 = 0, p2 = 0;
        while (k > 0 && p1 < nums1.length && p2 < nums2.length) {
            List<Integer> pair = new ArrayList<>(2);
            pair.add(nums1[p1]);
            pair.add(nums2[p2]);
            res.add(pair);
            k--;
            if (p1 + 1 < nums1.length && p2 + 1 < nums2.length) {
                if (nums1[p1 + 1] + nums2[p2] <= nums1[0] + nums2[p2 + 1]) {
                    p1 = p1 + 1;
                } else {
                    p2 = p2 + 1;
                    p1 = 0;
                }
            } else if (p1 + 1 >= nums1.length) {
                p2 = p2 + 1;
                p1 = 0;
            } else {
                p1 = p1 + 1;
            }
        }
        return res;
    }
}
