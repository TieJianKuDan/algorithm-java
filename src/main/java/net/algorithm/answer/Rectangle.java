package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/23 9:25
 * @Description 492. 构造矩形
 * @Since version-1.0
 */
public class Rectangle {
    public static void main(String[] args) {

    }

    public int[] constructRectangle(int area) {
        int temp = (int) Math.sqrt(area);
        int W =  temp;
        while ((area % W) != 0) {
            W--;
        }
        int L = area / W;
        return new int[]{L, W};
    }
}
