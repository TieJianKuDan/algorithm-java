package net.algorithm.answer;


import net.algorithm.pojo.special.Node;

public class FlattenList {
    public static void main(String[] args) {

    }

    public Node flatten(Node head) {
        Node[] nodes = help(head);
        return nodes[0];
    }

    private Node[] help(Node head) {
        Node p = head;
        Node pre = null;
        while (p != null) {
            if (p.child != null) {
                Node[] nodes = help(p.child);
                nodes[1].next = p.next;
                if (p.next != null)
                    p.next.prev = nodes[1];
                p.next = nodes[0];
                nodes[0].prev = p;
                p.child = null;
                p = nodes[1];
            }
            pre = p;
            p = p.next;
        }
        return new Node[]{head, pre};
    }
}
