package com.practice.problems;

public class AddTwoNumbersOfLinkedList {

    /*

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
     */

    public static void main(String[] args) {
        ListNode list1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode list2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));

        ListNode listNode = addTwoNumbers(list1, list2);

        while (listNode!=null){
            System.out.print(listNode.val+"\t");
            listNode = listNode.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryInt = 0;

        ListNode rootSumNode = null;
        ListNode curSumNode = null;

        while(l1!=null || l2!=null){

            if(rootSumNode == null){
                rootSumNode = new ListNode();
                curSumNode = rootSumNode;
            }else{
                ListNode newCurNode = new ListNode();
                curSumNode.next = newCurNode;
                curSumNode = newCurNode;
            }

            int l2Val = l2 == null ? 0 : l2.val;
            int l1Val = l1 == null ? 0 : l1.val;

            int newVal = l2Val + l1Val + carryInt;
            curSumNode.val = newVal % 10;
            carryInt = newVal / 10;

            l2 =  l2 == null ? null : l2.next;
            l1 =  l1 == null ? null : l1.next;
        }

        if(carryInt == 1){
            ListNode newCurNode = new ListNode(1);
            curSumNode.next = newCurNode;
        }

        return rootSumNode;

    }
}
