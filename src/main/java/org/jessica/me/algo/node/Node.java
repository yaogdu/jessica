package org.jessica.me.algo.node;
/**
 * 类Node的实现描述：  单向链表
 * @author duyaoguang 2020/8/16 8:42 上午
 */
public class Node {
     public int val;
     public Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node() {
    }
}
