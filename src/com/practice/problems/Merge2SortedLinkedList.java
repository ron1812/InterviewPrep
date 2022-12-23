package com.practice.problems;

public class Merge2SortedLinkedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        ListNode listNode = mergeTwoLists(list1, list2);

        while (listNode!=null){
            System.out.print(listNode.val+"\t");
            listNode = listNode.next;
        }

        System.out.println("\nAPPROACH 2\n");

        ListNode listNode2 = mergeTwoListsV2(list1, list2);

        while (listNode2!=null){
            System.out.print(listNode2.val+"\t");
            listNode2 = listNode2.next;
        }
    }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode rootNewNode = null;
        ListNode currNewNode = null;
        ListNode curr = list1;
        ListNode curr1 = list2;
        while(curr != null && curr1 != null){
            if(rootNewNode == null){
                rootNewNode = new ListNode();
                currNewNode = rootNewNode;
            }
            if(curr.val > curr1.val){
                currNewNode.val = curr1.val;
                curr1 = curr1.next;
            }else if(curr1.val >= curr.val){
                currNewNode.val = curr.val;
                curr = curr.next;
            }
            if(curr != null && curr1 != null){

                ListNode nodeNew = new ListNode();
                currNewNode.next = nodeNew;
                currNewNode = nodeNew;
            }
        }

         while(curr!=null){
              ListNode nodeNew = new ListNode(curr.val);
              currNewNode.next = nodeNew;
              currNewNode = nodeNew;
              curr = curr.next;
         }

          while(curr1!=null){
             ListNode nodeNew = new ListNode(curr1.val);
             currNewNode.next = nodeNew;
             currNewNode = nodeNew;
             curr1 = curr1.next;
         }

        return rootNewNode;
    }

    public static ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1!= null || list2!=null){
            if(list2 == null || (list1!=null && list1.val < list2.val)){
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        return head.next;
    }

    public ListNode mergeTwoListsV3(ListNode list1, ListNode list2) {
        if (list1 == null || list2==null) return list1!=null? list1:list2;
        ListNode res = new ListNode(-1);
        ListNode tempRes = res;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null){
            if (temp1.val< temp2.val){
                tempRes.next = temp1;
                temp1=temp1.next;
            }
            else{
                tempRes.next = temp2;
                temp2 = temp2.next;
            }
            tempRes = tempRes.next;
        }
        tempRes.next = temp1 == null? temp2:temp1;
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
