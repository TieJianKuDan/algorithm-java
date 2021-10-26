package net.algorithm.answer;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/26 9:47
 * @Description 496. 下一个更大元素 I
 * @Since version-1.0
 */
public class NextGreaterEle {
    public static void main(String[] args) {
        
    }

    /**
     * 单调栈解决下一个更大元素的问题
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(len2);
        int[] result = new int[len1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = len2 - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < len1; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
