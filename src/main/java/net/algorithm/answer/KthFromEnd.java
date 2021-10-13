package net.algorithm.answer;

import net.algorithm.pojo.ListNode;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/2 10:37
 * @Description 剑指 Offer 22. 链表中倒数第k个节点
 * @Since version-1.0
 */
public class KthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;
        while (fast.next != null) {
            if (count == k) {
                fast = fast.next;
                slow = slow.next;
            } else {
                fast = fast.next;
                count++;
            }
        }
        return slow;
    }
}
