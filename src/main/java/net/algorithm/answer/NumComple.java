package net.algorithm.answer;

public class NumComple {
    public static void main(String[] args) {
        System.out.println(new NumComple().findComplement(5));
    }

    /**
     * int 的高位如果是 0 不应该取反，所以先让高位取反然后在整体取反
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int helper = 1 << 31;
        num = num | helper;
        helper >>>= 1;
        while (helper >= 1) {
            if ((num & helper) != 0) {
                break;
            }
            num = num | helper;
            helper >>>= 1;
        }
        return ~num;
    }
}
