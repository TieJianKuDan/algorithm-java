package net.algorithm.answer;

public class PaintingPlan {
    public static void main(String[] args) {
        System.out.println(new PaintingPlan().paintingPlan(2, 2));
    }

    public int paintingPlan(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (k == n * n) {
            return 1;
        }
        if (k < n) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((k - n * i) % (n - i) != 0) {
                continue;
            }
            int j = (k - n * i) / (n - i);
            if (j < 0) {
                continue;
            }
            res += select(n, i) * select(n, j);
        }
        return res;
    }

    public int select(int n, int m) {
        int fenzi = 1;
        int fenmu = 1;
        for (int i = 1; i <= m; i++) {
            fenmu *= i;
            fenzi *= (n - i + 1);
        }
        return fenzi / fenmu;
    }
}
