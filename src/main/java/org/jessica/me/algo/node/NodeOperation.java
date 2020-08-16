package org.jessica.me.algo.node;

import com.alibaba.fastjson.JSON;

/**
 * 类ReverseNode的实现描述：
 * @author duyaoguang 2020/8/16 8:45 上午
 */
public class NodeOperation {

    public static void main(String[] args) {
        Node node5 = new Node(5,null);

        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        System.out.println(JSON.toJSONString(node1));
        node5.next = node2;
        //reverseNode(node1);

        detectCircle(node1);
    }


    public static void reverseNode(Node head){
        if(head == null){
            System.out.println("node is null");
        }
        
        Node pre = null;
        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            System.out.println("loop");
        }

        System.out.println(JSON.toJSONString(pre));
    }

    public static void detectCircle(Node head){
        Node fast = head;
        Node slow = head;
        System.out.print("looking.");
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                System.out.println("circle found: " + JSON.toJSONString(fast.val));
                break;
            }
            System.out.print(".");
        }
    }


}
