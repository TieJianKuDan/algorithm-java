package net.algorithm.answer;

import java.util.*;

public class InvalidParentheses {
    public static void main(String[] args) {
        String s = "(a)())()";
        InvalidParentheses self = new InvalidParentheses();
        System.out.println(self.removeInvalidParentheses(s));
    }

    private Set<String> rem = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        if (isLegal(s)) {
            set.add(s);
            return new ArrayList<>(set);
        }
        HashMap<String, Integer> res = new HashMap<>();
        dfs(s, res, s.length(), s.length());
        Set<Map.Entry<String, Integer>> entries = res.entrySet();
        int minStep = s.length();
        for (Map.Entry<String, Integer> entry : entries) {
            minStep = Math.min(minStep, entry.getValue());
        }
        int step = minStep;
        res.forEach((key, value) -> {
            if (value <= step) {
                set.add(key);
            }
        });
        return new ArrayList<>(set);
    }

    /**
     * 回溯寻找所有的最小删除的结果
     *
     * @param s
     * @param res
     * @param minStep
     */
    private int dfs(String s, Map<String, Integer> res, int minStep, int restStep) {
        if (restStep <= 0) {
            return minStep;
        }
        if (rem.contains(s)) {
            return minStep;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                restStep--;
                String candidate = s.substring(0, i) + s.substring(i + 1, s.length());
                if (isLegal(candidate)) {
                    int spend = minStep - restStep;
                    minStep = Math.min(minStep - restStep, minStep);
                    restStep = Math.min(restStep, minStep - spend);
                    res.put(candidate, minStep);
                } else {
                    dfs(candidate, res, minStep, restStep);
                }
                restStep++;
            }
        }
        rem.add(s);
        return minStep;
    }

    /**
     * 判断字符串是否合法
     *
     * @param s
     * @return
     */
    private boolean isLegal(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char temp = s.charAt(index);
            if (temp == ')') {
                boolean flag = false;
                while (!stack.isEmpty()) {
                    Character companion = stack.pop();
                    if (companion == '(') {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            } else {
                stack.push(temp);
            }
            index++;
        }
        while (!stack.isEmpty()) {
            char temp = stack.pop();
            if (temp == '(' || temp == ')') {
                return false;
            }
        }
        return true;
    }
}
