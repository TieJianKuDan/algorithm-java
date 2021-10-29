package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/29 18:33
 * @Description 335. 路径交叉
 * @Since version-1.0
 */
public class SelfCrossing {
    public static void main(String[] args) {
        int[] distance = {1, 1, 3, 2, 1, 1};
        SelfCrossing self = new SelfCrossing();
        System.out.println(self.isSelfCrossing(distance));
    }

    public boolean isSelfCrossing(int[] distance) {
        int len = distance.length;
        if (len < 4) {
            return false;
        }
        for (int i = 3; i < len; i++) {
            if (distance[i] >= distance[i - 2] &&
                    distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            if (i > 3 &&
                    distance[i - 1] == distance[i - 3] &&
                    distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }
            if (i > 4 &&
                    distance[i - 4] < distance[i - 2] &&
                    distance[i - 1] <= distance[i - 3] &&
                    distance[i] + distance[i - 4] >= distance[i - 2] &&
                    distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
