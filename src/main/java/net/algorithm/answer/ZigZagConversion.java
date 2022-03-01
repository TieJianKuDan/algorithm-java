package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2022/3/1 10:13
 * @Description 6. Z 字形变换
 * @Since version-1.0
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion self = new ZigZagConversion();
        System.out.println(self.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        int count = s.length();
        if (count <= numRows) {
            return s;
        }
        ArrayList<List<Character>> strs = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Character> str = new ArrayList<>();
            str.add(s.charAt(i));
            strs.add(i, str);
        }
        char[] arr = s.substring(numRows, count).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int temp = i / (numRows - 1);
            int index = i % (numRows - 1);
            if (temp % 2 == 0) {
                strs.get(numRows - index - 2).add(arr[i]);
            } else {
                strs.get(index + 1).add(arr[i]);
            }
        }
        StringBuilder builder = new StringBuilder(count);
        for (int i = 0; i < numRows; i++) {
            List<Character> str = strs.get(i);
            char[] temp = new char[str.size()];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = str.get(j);
            }
            builder.append(new String(temp));
        }
        return builder.toString();
    }
}
