package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/19 9:41
 * @Description 211. 添加与搜索单词 - 数据结构设计
 * @Since version-1.0
 */
public class WordDictionary {
    public static void main(String[] args) {

    }

    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return help(word, 0, root);
    }

    public boolean help(String word, int start, Trie root) {
        if (start == word.length()) {
            return root.isEnd;
        }
        boolean res = false;
        if (word.charAt(start) == '.') {
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null) {
                    res = res || help(word, start + 1, root.children[i]);
                }
                if (res) {
                    return res;
                }
            }
            return res;
        } else {
            int site = word.charAt(start) - 'a';
            if (root.children[site] != null) {
                res = help(word, start + 1, root.children[site]);
            }
            return res;
        }
    }

    /**
     * @Author TieJianKuDan
     * @Date 2021/10/19 9:41
     * @Description 前缀树（字典树）
     * @Since version-1.0
     */
    class Trie {
        boolean isEnd;
        Trie[] children = new Trie[26];

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int site = word.charAt(i) - 97;
                if (node.children[site] == null) {
                    node.children[site] = new Trie();
                }
                node = node.children[site];
            }
            node.isEnd = true;
        }
    }
}
