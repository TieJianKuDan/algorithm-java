package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/25 9:34
 * @Description 458. 可怜的小猪
 * @Since version-1.0
 */
public class PoorPigs {
    public static void main(String[] args) {

    }

    /**
     * 测试 i 轮每一只猪都能提供 i + 1 中状态，那么 n 只猪就能提供 (i + 1)^n 中状态，那么存在一种合理的设计可以在 i 轮后，可以检测最多 (i + 1)^ n 瓶毒药
     * 至于实验怎么设计，这不清楚。
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int iteration = minutesToTest / minutesToDie;
        return (int)Math.ceil(Math.log(buckets) / Math.log(iteration + 1));
    }
}
