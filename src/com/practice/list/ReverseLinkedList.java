package com.practice.list;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode currPrev = null;

        while(curr != null){

            ListNode temp = curr.next;
            curr.next = currPrev;
            currPrev = curr;
            curr = temp;
        }
        return currPrev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode listNode = reverseList(head);

        while (listNode.next!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}