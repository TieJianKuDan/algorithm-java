package net.algorithm.answer;

public class DigitOne {
    public static void main(String[] args) {
        System.out.println(countDigitOne(824883294));
    }

    public static int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
