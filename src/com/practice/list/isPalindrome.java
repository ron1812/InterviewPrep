package com.practice.list;

public class isPalindrome {

    public static boolean isPalindrome(ListNode head) {
        ListNode midNode = getMiddleNode(head);
        ListNode lastNode = reverseList(midNode.next,midNode);

        ListNode endPt = lastNode;
        ListNode startPt = head;
        while(endPt!=null && endPt != startPt){

            if(endPt.val != startPt.val){
                return false;
            }else{
                startPt = startPt.next;
                endPt = endPt.next;
            }
        }
        return true;
    }

    public static ListNode reverseList(ListNode head,ListNode prevHeadNode){
        ListNode curr = head;
        ListNode preNode = prevHeadNode;
        preNode.next = null;
        while(curr!=null){

            ListNode temp = curr.next;
            curr.next = preNode;
            preNode = curr;
            curr = temp;
        }
        return preNode;
    }

    public static ListNode getMiddleNode(ListNode head){
        ListNode slowPt = head;
        ListNode fastPt = head;

        while(fastPt!=null && fastPt.next!=null){
            fastPt = fastPt.next.next;
            slowPt = slowPt.next;
        }

        return slowPt;
    }

    public static void main(String[] args) {
        //ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(2,new ListNode(1,null)))));
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1,null))));

        System.out.println(isPalindrome(head));
    }
}
