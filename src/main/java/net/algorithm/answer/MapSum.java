package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/14 9:30
 * @Description 677. 键值映射
 * @Since version-1.0
 */
public class MapSum {
    private DicTree root;

    public MapSum() {
        this.root = new DicTree();
    }

    public void insert(String key, int val) {
        root.insert(key, val);
    }

    public int sum(String prefix) {
        return root.getSumByPrefix(prefix);
    }

    class DicTree {
        int val = 0;
        boolean isEnd = false;
        DicTree[] children = new DicTree[26];

        void insert(String key, int val) {
            DicTree node = this;
            for (int i = 0; i < key.length(); i++) {
                if (node.children[key.charAt(i) - 97] == null) {
                    node.children[key.charAt(i) - 97] = new DicTree();
                }
                node = node.children[key.charAt(i) - 97];
            }
            node.val = val;
            node.isEnd = true;
        }

        int getSumByPrefix(String prefix) {
            DicTree node = this;
            for (int i = 0; i < prefix.length(); i++) {
                DicTree child = node.children[prefix.charAt(i) - 97];
                if (child == null) {
                    return 0;
                }
                node = child;
            }
            return getAllVals(node);
        }

        int getAllVals(DicTree root) {
            int res = 0;
            if (root == null) {
                return 0;
            }
            if (root.isEnd) {
                res += root.val;
            }
            for (int i = 0; i < 26; i++) {
                res += getAllVals(root.children[i]);
            }
            return res;
        }
    }
}
