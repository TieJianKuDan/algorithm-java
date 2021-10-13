package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/23 11:19
 * @Description 238. 除自身以外数组的乘积
 * @Since version-1.0
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    public int[] productExceptSelf(int[] nums) {
        // 使用前缀乘和后缀乘
        int len = nums.length;
        int[] prefix = new int[len];
        prefix[0] = nums[0];
        int[] suffix = new int[len];
        suffix[len - 1] = nums[len - 1];
        int[] res = new int[len];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[len - i - 1] = suffix[len - i] * nums[len - i - 1];
        }
        res[0] = suffix[1];
        res[len - 1] = prefix[len - 2];
        for (int i = 1; i < len - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        return res;
    }
}
