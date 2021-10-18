package net.algorithm.answer;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestWord {
    public static void main(String[] args) {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        System.out.println(new LongestWord().longestWordPro(words));
    }

    private String res = "";

    /**
     * 暴力解法
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        String res = "";
        ArrayList<String> candidates = new ArrayList<>();
        HashSet<String> record = new HashSet<>();
        for (String word : words) {
            record.add(word);
        }
        boolean flag = true;
        for (String word : words) {
            flag = true;
            int end = word.length() - 1;
            while (end > 0) {
                String temp = word.substring(0, end);
                if (!record.contains(temp)) {
                    flag = false;
                    break;
                }
                end--;
            }
            if (flag && word.length() > res.length()) {
                res = word;
                candidates.clear();
            } else if (flag && word.length() == res.length()) {
                candidates.add(word);
            }
        }
        for (String candidate : candidates) {
            for (int i = 0; i < candidate.length(); i++) {
                if (candidate.charAt(i) < res.charAt(i)) {
                    res = candidate;
                    break;
                } else if (candidate.charAt(i) > res.charAt(i)) {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 字典树解法(还不如暴力？)
     */
    final private String CHARMAP = "abcdefghijklmnopqrstuvwxyz";


    public String longestWordPro(String[] words) {
        char[] map = CHARMAP.toCharArray();
        Node root = new Node();
        root.end = true;
        for (String word : words) {
            insert(word, 0, root);
        }
        dfs(root, new StringBuilder());
        return res;
    }

    private class Node {
        char val = '\0';
        boolean end = false;
        Node[] nodes = new Node[26];

    }

    private void insert(String word, int start, Node root) {
        int site = word.charAt(start) - 97;
        if (root.nodes[site] == null) {
            root.nodes[site] = new Node();
            root.nodes[site].val = word.charAt(start);
        }
        if (word.length() == start + 1) {
            root.nodes[site].end = true;
        } else {
            insert(word, start + 1, root.nodes[site]);
        }
    }

    private void dfs(Node root, StringBuilder candidate) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.nodes.length; i++) {
            if (!root.end) {
                break;
            }
            if (root.val != '\0') {
                candidate.append(root.val);
            }
            if (res.length() < candidate.toString().length()) {
                res = candidate.toString();
            } else if (res.length() == candidate.toString().length()) {
                for (int j = 0; j < candidate.toString().length(); j++) {
                    if (candidate.toString().charAt(j) < res.charAt(j)) {
                        res = candidate.toString();
                        break;
                    } else if (candidate.toString().charAt(j) > res.charAt(j)) {
                        break;
                    }
                }
            }
            dfs(root.nodes[i], candidate);
            if (root.val != '\0'){
                candidate.deleteCharAt(candidate.length() - 1);
            }
        }
    }
}
