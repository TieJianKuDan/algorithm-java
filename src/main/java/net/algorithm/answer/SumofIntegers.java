package net.algorithm.answer;

public class SumofIntegers {
    public static void main(String[] args) {
        System.out.println(new SumofIntegers().getSum(1, 99));
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            // 计算每一位的进位
            int carry = (a & b) << 1;
            // 计算 a 和 b 的半加
            a = a ^ b;
            // 因为会产生进位，所以还要加上进位
            // 又因为加上进位有可能产生新的进位，所以需要循环
            b = carry;
        }
        return a;
    }
}
