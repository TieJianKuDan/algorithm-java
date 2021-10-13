package net.algorithm.answer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/19 10:31
 * @Description 345. 反转字符串中的元音字母
 * @Since version-1.0
 */
public class Vowels {
    public static void main(String[] args) {
        System.out.println(new Vowels().reverseVowels("leetcode"));;
    }

    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<Character>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
        char[] charArray = s.toCharArray();
        int low = 0, high = charArray.length - 1;
        while (true) {
            while (low <= high && !vowels.contains(charArray[low])) {
                low++;
            }
            while (low <= high && !vowels.contains(charArray[high])) {
                high--;
            }
            if (low > high) {
                break;
            }
            char temp = charArray[low];
            charArray[low] = charArray[high];
            charArray[high] = temp;
            high--;
            low++;
        }
        return new String(charArray);
    }
}
