package net.algorithm.answer;

import net.algorithm.pojo.Node;

import java.util.ArrayList;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/22 15:11
 * @Description 复制带随机指针的链表
 * @Since version-1.0
 */
public class CopyRandomList {
    public static void main(String[] args) {

    }
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> oldNodes = new ArrayList<Node>();
        ArrayList<Node> newNodes = new ArrayList<Node>();
        Node point = head;
        while (point != null) {
            oldNodes.add(point);
            point = point.next;
        }
        for (int i = 0; i < oldNodes.size() ; i++) {
            newNodes.add(new Node(oldNodes.get(i).val));
        }
        for (int i = 0; i < newNodes.size(); i++) {
            if (i != newNodes.size() - 1) {
                newNodes.get(i).next = newNodes.get(i + 1);
            }
            if (oldNodes.get(i).random != null) {
                for (int j = 0; j < oldNodes.size(); j++) {
                    if (oldNodes.get(i).random == oldNodes.get(j)) {
                        newNodes.get(i).random = newNodes.get(j);
                        break;
                    }
                }
            } else {
                newNodes.get(i).random = null;
            }
        }
        return newNodes.get(0);
    }
}
