package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/26 10:48
 * @Description 881.救生艇
 * @Since version-1.0
 */
public class RescueBoats {
    public static void main(String[] args) {

    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0;
        int high = people.length - 1;
        int count = 0;
        while (low <= high) {
            if (people[high] + people[low] <= limit) {
                count++;
                low++;
                high--;
            } else {
                count++;
                high--;
            }
        }
        return count;
    }
}
