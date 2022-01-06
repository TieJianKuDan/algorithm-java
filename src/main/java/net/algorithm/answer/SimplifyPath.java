package net.algorithm.answer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author TieJianKuDan
 * @Date 2022/1/6 10:40
 * @Description 71. 简化路径
 * @Since version-1.0
 */
public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath self = new SimplifyPath();
        System.out.println(self.simplifyPath("/.../"));
    }

    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        while (index < path.length()) {
            char temp = path.charAt(index);
            if (temp == '/') {
                if (stack.isEmpty() || stack.peekFirst() != '/') {
                    stack.push(temp);
                }
                index++;
            } else if (temp == '.') {
                if (index + 1 >= path.length() || path.charAt(index + 1) == '/') {
                    index += 2;
                } else if (path.charAt(index + 1) == '.' &&
                        (index + 2 >= path.length() || path.charAt(index + 2) == '/')) {
                    stack.pop();
                    while (stack.size() > 0 && stack.peekFirst() != '/') {
                        stack.pop();
                    }
                    if (stack.size() == 0) {
                        stack.push('/');
                    }
                    index += 3;
                } else {
                    while (index < path.length() && (temp = path.charAt(index)) != '/') {
                        stack.push(temp);
                        index++;
                    }
                }
            } else {
                while (index < path.length() && (temp = path.charAt(index)) != '/') {
                    stack.push(temp);
                    index++;
                }
            }
        }
        if (stack.peekFirst() == '/' && stack.size() > 1) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }
}
