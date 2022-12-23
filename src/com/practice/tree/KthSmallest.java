package com.practice.tree;

import java.util.Random;
import java.util.Stack;

public class KthSmallest {

    public static void main(String[] args) {
        int i = new Random().nextInt(2);

        System.out.println(i);
//        TreeNodeV2 root = new TreeNodeV2(3,new TreeNodeV2(1,null,new TreeNodeV2(2,null,null)),new TreeNodeV2(4,null,null));
//
//        System.out.println(kthSmallest(root,new int[]{3}));
//        System.out.println(kthSmallestV2(root,4));
    }

    public static int kthSmallest(TreeNodeV2 root, int k[]) {

        TreeNodeV2 treeNodeV2 = inOrder(root, k);
        return treeNodeV2.val;
    }

    public static int kthSmallestV2(TreeNodeV2 root,int k){

        Stack<TreeNodeV2> trav = new Stack<>();
        TreeNodeV2 curr = root;

        while(curr != null || !trav.isEmpty()){

            while(curr != null){
                trav.push(curr);
                curr = curr.left;
            }

            curr = trav.pop();

            k--;
            if(k == 0){
               return curr.val;
            }

            curr = curr.right;
        }
        return Integer.MIN_VALUE;
    }

    public static TreeNodeV2 inOrder(TreeNodeV2 root,int k[]){

        if(root == null){

            return null;
        }

        TreeNodeV2 left = inOrder(root.left,k);
        if(left!=null)
            return left;

        k[0]--;

        if(k[0] == 0){
            return root;
        }

        return inOrder(root.right,k);
    }
}

class TreeNodeV2 {

    int val;
    TreeNodeV2 left;
    TreeNodeV2 right;

    TreeNodeV2() {}

    TreeNodeV2(int val) { this.val = val; }

    TreeNodeV2(int val, TreeNodeV2 left, TreeNodeV2 right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}
