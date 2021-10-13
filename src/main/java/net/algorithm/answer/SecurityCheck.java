package net.algorithm.answer;

import java.util.Arrays;

public class SecurityCheck {
    public static void main(String[] args) {
        System.out.println(new SecurityCheck().securityCheck(new int[]{4,3,2,2}, 6));
    }

    public int securityCheck(int[] capacities, int k) {
        int sum = 0;
        for (int i = 0; i < capacities.length; i++) {
            sum += capacities[i];
        }
        int[][] rem = new int[capacities.length][sum];
        for (int[] ele : rem) {
            Arrays.fill(ele, -1);
        }
        return dfs(capacities, capacities.length - 1, k, 0, sum, rem);
    }

    public int dfs(int[] capacties, int index, int k, int target, int sum, int[][] rem) {
        int res = 0;
        if (index == 0) {
            if (k == target) {
                res++;
            }
            if (k < capacties[0] - 1 && target == sum - k - 1) {
                res++;
            } else if (k >= capacties[0] - 1 && target == k - capacties[0] + 1) {
                res++;
            }
            return res;
        }
        if (rem[index][target] != -1) {
            return rem[index][target];
        }
        res = dfs(capacties, index - 1, k, target, sum, rem) + dfs(capacties, index - 1, k, target + capacties[index] - 1, sum, rem);
        rem[index][target] = res;
        return res;
    }
}
