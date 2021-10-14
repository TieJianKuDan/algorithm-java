package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/14 9:13
 * @Description 剑指 Offer II 069. 山峰数组的顶部
 * @Since version-1.0
 */
public class MountainArray {
    public static void main(String[] args) {
        System.out.println(new MountainArray().peakIndexInMountainArray(new int[]{0, 1, 0}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int cen = (high - low) / 2 + low;
            if (arr[cen] < arr[cen + 1]) {
                low = cen + 1;
            } else {
                high = cen;
            }
        }
        return low;
    }
}
