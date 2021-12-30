package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/30 9:39
 * @Description 846. 一手顺子
 * @Since version-1.0
 */
public class NStraightHand {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3};
        NStraightHand self = new NStraightHand();
        System.out.println(self.isNStraightHand(hand, 1));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        int first = 0;
        while (first < hand.length) {
            int target = hand[first] + 1;
            int end = hand[first] + groupSize;
            boolean flag = false;
            for (int i = first + 1; i < hand.length; i++) {
                if (hand[i] == target) {
                    hand[i] = -1;
                    target++;
                }
                if (target >= end) {
                    break;
                }
            }
            if (target < end) {
                return false;
            }
            for (int i = first + 1; i < hand.length; i++) {
                if (hand[i] >= 0) {
                    first = i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return true;
    }
}
