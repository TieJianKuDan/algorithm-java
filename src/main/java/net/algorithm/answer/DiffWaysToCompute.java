package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    public static void main(String[] args) {
        System.out.println(new DiffWaysToCompute().diffWaysToCompute("-2"));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> res = new ArrayList<>(8);
        boolean flag = true;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                flag = false;
                List<Integer> lefts = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rights = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                switch (expression.charAt(i)) {
                    case '+':
                        for (Integer left : lefts) {
                            for (Integer right : rights) {
                                res.add(left + right);
                            }
                        }
                        break;
                    case '-':
                        for (Integer left : lefts) {
                            for (Integer right : rights) {
                                res.add(left - right);
                            }
                        }
                        break;
                    case '*':
                        for (Integer left : lefts) {
                            for (Integer right : rights) {
                                if (left == null || right == null) {

                                }
                                res.add(left * right);
                            }
                        }
                        break;
                }
            }
        }
        if (flag) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
