package net.algorithm.answer;

public class VolunteerDeployment {
    public static void main(String[] args) {
        System.out.println(new VolunteerDeployment().volunteerDeployment(new int[]{1, 16}, 21, new int[][]{{0, 1}, {1, 2}}, new int[][]{{2, 1}, {1, 0}, {3, 0}}));
    }

    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int[] res = new int[finalCnt.length + 1];
        int[] countOfX = new int[res.length];
        countOfX[0] = 1;
        for (int i = 0; i < finalCnt.length; i++) {
            res[i + 1] = finalCnt[i];
        }
        for (int i = plans.length - 1; i >= 0; i--) {
            // 方案一
            if (plans[i][0] == 1) {
                res[plans[i][1]] *= 2;
                countOfX[plans[i][1]] *= 2;
            }
            // 方案二
            else if (plans[i][0] == 2) {
                case2(edges, plans[i][1], res, countOfX);
            }
            // 方案三
            else if (plans[i][0] == 3) {
                case3(edges, plans[i][1], res, countOfX);
            }
        }
        int sumX = countOfX[0], sumNum = 0;
        for (int i = 1; i < res.length; i++) {
            sumNum += res[i];
            sumX += countOfX[i];
        }
        int x = (int)(totalNum - sumNum) / sumX;
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] + countOfX[i] * x;
        }
        return res;
    }

    public void case2(int[][] edges, int index, int[] res, int[] countOfX) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == index) {
                if (index == 0) {
                    countOfX[edges[i][1]] -= countOfX[0];
                } else {
                    countOfX[edges[i][0]] += countOfX[index];
                    res[edges[i][1]] -= res[index];
                }
            }
            if (edges[i][1] == index) {
                if (index == 0) {
                    countOfX[edges[i][0]] -= countOfX[0];
                } else {
                    countOfX[edges[i][0]] += countOfX[index];
                    res[edges[i][0]] -= res[index];
                }
            }
        }
    }

    public void case3(int[][] edges, int index, int[] res, int[] countOfX) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == index) {
                if (index == 0) {
                    countOfX[edges[i][1]] += countOfX[0];
                } else {
                    res[edges[i][1]] += res[index];
                    countOfX[edges[i][1]] += countOfX[index];
                }
            }
            if (edges[i][1] == index) {
                if (index == 0) {
                    countOfX[edges[i][0]] += countOfX[0];
                } else {
                    res[edges[i][0]] += res[index];
                    countOfX[edges[i][0]] += countOfX[index];
                }
            }
        }
    }

}
