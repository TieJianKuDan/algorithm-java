package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2022/2/25 9:36
 * @Description 537. 复数乘法
 * @Since version-1.0
 */
public class ComplexNumberMultiply {
    public static void main(String[] args) {

    }

    public String complexNumberMultiply(String num1, String num2) {
        int[] n1 = help(num1);
        int[] n2 = help(num2);
        int real = n1[0] * n2[0] - n1[1] * n2[1];
        int virtual = n1[0] * n2[1] + n1[1] * n2[0];
        String res = "" + real + "+" + virtual + "i";
        return res;
    }

    private int[] help(String num) {
        String[] nums = num.split("\\+");
        nums[1] = nums[1].substring(0, nums[1].length() - 1);
        int real = Integer.parseInt(nums[0]);
        int virtual = Integer.parseInt(nums[1]);
        return new int[]{real, virtual};
    }
}
