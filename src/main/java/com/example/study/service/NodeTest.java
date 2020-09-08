package com.example.study.service;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-24 17:42
 **/
public class NodeTest {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
       ListNode listNode = addTwoNumbers(l1,l2);
        System.out.println("结果："+listNode.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }



    public static void sout(){
        ListNode listNode = new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        listNode.val = 1;
        listNode.next= firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        System.out.println("secondNode 的值为："+listNode.val);
        System.out.println("secondNode 的值为："+listNode.next.val);
        System.out.println("secondNode 的值为："+listNode.next.next.val);
        System.out.println("secondNode 的值为："+listNode.next.next.next.val);
//        secondNode 的值为：1
//        secondNode 的值为：1
//        secondNode 的值为：2
//        secondNode 的值为：3
    }


}
