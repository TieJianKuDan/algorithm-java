package net.algorithm.answer;

import net.algorithm.pojo.TreeNode;

import java.util.*;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/31 20:42
 * @Description 987. 二叉树的垂序遍历
 * @Since version-1.0
 */
public class VerticalTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = verticalTraversal(root);
        System.out.println(lists);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        TreeMap<Integer, List<Integer>> value = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        value.put(0, list);
        map.put(0, value);

        help(root, new int[]{0, 0}, map);

        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
            TreeMap<Integer, List<Integer>> valueMap = map.get(integer);
            List<Integer> temp = new ArrayList<>();
            Set<Map.Entry<Integer, List<Integer>>> entries = valueMap.entrySet();
            for (Map.Entry<Integer, List<Integer>> entry : entries) {
                List<Integer> v = entry.getValue();
                v.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
                temp.addAll(v);
            }
            res.add(temp);
        }
        return res;
    }

    public static void help(TreeNode root, int[] coordinate, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root.left != null) {
            int x = coordinate[0] + 1;
            int y = coordinate[1] - 1;
            TreeMap<Integer, List<Integer>> value = map.getOrDefault(y, new TreeMap<Integer, List<Integer>>());
            List<Integer> list = value.getOrDefault(x, new ArrayList<Integer>());
            list.add(root.left.val);
            value.put(x, list);
            map.put(y, value);
            help(root.left, new int[]{x, y}, map);
        }
        if (root.right != null) {
            int x = coordinate[0] + 1;
            int y = coordinate[1] + 1;
            TreeMap<Integer, List<Integer>> value = map.getOrDefault(y, new TreeMap<Integer, List<Integer>>());
            List<Integer> list = value.getOrDefault(x, new ArrayList<Integer>());
            list.add(root.right.val);
            value.put(x, list);
            map.put(y, value);
            help(root.right, new int[]{x, y}, map);
        }
    }

}
