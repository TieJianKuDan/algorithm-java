package net.algorithm.answer;

import java.util.*;

public class InvalidParentheses {
    public static void main(String[] args) {
        String s = "((()";
        InvalidParentheses self = new InvalidParentheses();
        System.out.println(self.removeInvalidParentheses(s));
    }

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        if (isLegal(s)) {
            set.add(s);
            return new ArrayList<>(set);
        }
        HashMap<String, Integer> res = new HashMap<>();
        dfs(s.toCharArray(), res, s.length(), s.length());
        Set<Map.Entry<String, Integer>> entries = res.entrySet();
        int minStep = s.length();
        for (Map.Entry<String, Integer> entry : entries) {
            minStep = Math.min(minStep, entry.getValue());
        }
        int step = minStep;
        res.forEach((key, value) -> {
            if (value <= step) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < key.length(); i++) {
                    if (key.charAt(i) != ' ') {
                        builder.append(s.charAt(i));
                    }
                }
                set.add(builder.toString());
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
    private int dfs(char[] s, Map<String, Integer> res, int minStep, int restStep) {
        if (restStep <= 0) {
            return minStep;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(' || s[i] == ')') {
                char temp = s[i];
                s[i] = ' ';
                restStep--;
                String candidate = new String(s);
                if (isLegal(candidate)) {
                    int spend = minStep - restStep;
                    minStep = Math.min(minStep - restStep, minStep);
                    restStep = Math.min(restStep, minStep - spend);
                    res.put(candidate, minStep);
                } else {
                    dfs(s, res, minStep, restStep);
                }
                restStep++;
                s[i] = temp;
            }
        }
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
