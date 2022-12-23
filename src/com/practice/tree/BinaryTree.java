package com.practice.tree;

import java.util.*;

public class BinaryTree {

    public static TreeNode root;

//             3
//         1        5
//      -1    2        10

    /*
      LEFT --> RIGHT --> ROOT  (POST ORDER)
     -1 --> 2 --> 1  --> 10 --> 5 --> 3

      LEFT --> ROOT --> RIGHT  (IN ORDER)
     -1 --> 1 --> 2  --> 3 --> 5 --> 10

      ROOT --> LEFT --> RIGHT (PRE ORDER)
      3 --> 1 --> -1 --> 2  --> 5 --> 10

      BREADTH FIRST
      3 --> 1 --> 5 --> -1 --> 2 --> 10

     */
    public static void main(String[] args) {
        BinaryTree binaryTree =  new BinaryTree();
        binaryTree.add(root,3);
        binaryTree.add(root,5);
        binaryTree.add(root,1);
        binaryTree.add(root,-1);
        binaryTree.add(root,10);
        binaryTree.add(root,2);

        System.out.println("Tree created");

        System.out.println("Pre Order");
        preOrderTraversal(root);

        System.out.println("\nPre Order Iterative");
        preOrderTraversalIterative(root);

        System.out.println("\nIn Order Recursive");
        inOrderTraversal(root);

        System.out.println("\nIn Order Iterative");
        inOrderTraversalIterative(root);

        System.out.println("\nPost Order");
        postOrderTraversal(root);

        System.out.println("\nPost Order Iterative");
        postOrderTraversalIterative(root);

        System.out.println("\nbreadth first traversal");
        breadthFirstTrav();

        System.out.println("\nheight of tree \n"+heightOfTree(root));
    }

    public static int heightOfTree(TreeNode node){
        if(node == null){
            return 0;
        }

        int heightOfLeftSubTree = heightOfTree(node.leftNode);
        int heightOfRightSubTree = heightOfTree(node.leftNode);

        return Math.max(heightOfLeftSubTree,heightOfRightSubTree) + 1;
    }

    public static void breadthFirstTrav(){
       Queue<TreeNode> bftravQueue =  new LinkedList();
       bftravQueue.add(root);

       while(!bftravQueue.isEmpty()){
           TreeNode treeNode = bftravQueue.remove();
           Integer data = treeNode.data;

           System.out.print(data+"\t");
           if(treeNode.leftNode != null)
               bftravQueue.add(treeNode.leftNode);
           if(treeNode.rightNode != null)
               bftravQueue.add(treeNode.rightNode);
       }
    }

    // LEFT --> ROOT --> RIGHT
    // -1 --> 1 --> 2  --> 3 --> 5 --> 10
    public static void inOrderTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }else{
            inOrderTraversal(treeNode.leftNode);
            System.out.print(treeNode.data+"\t");
            inOrderTraversal(treeNode.rightNode);
        }
    }

    public static void inOrderTraversalIterative(TreeNode root) {

        Stack<TreeNode> trav = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !trav.isEmpty()){

            while(curr != null){
                trav.push(curr);
                curr = curr.leftNode;
            }

            curr = trav.pop();
            System.out.print(curr.data+"\t");
            curr = curr.rightNode;
        }
    }

    // ROOT --> LEFT --> RIGHT
    // 3 --> 1 --> -1 --> 2  --> 5 --> 10
    public static void preOrderTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }else{
            System.out.print(treeNode.data+"\t");
            preOrderTraversal(treeNode.leftNode);
            preOrderTraversal(treeNode.rightNode);
        }
    }

    public static void preOrderTraversalIterative(TreeNode root) {

        Stack<TreeNode> trav = new Stack<>();
        trav.push(root);

        while(!trav.isEmpty()){

            TreeNode curr = trav.pop();
            System.out.print(curr.data+"\t");

            if(curr.rightNode != null){
                trav.push(curr.rightNode);
            }

            if(curr.leftNode != null){
                trav.push(curr.leftNode);
            }
        }
    }


    // LEFT --> RIGHT --> ROOT
    // -1 --> 2 --> 1  --> 10 --> 5 --> 3
    public static void postOrderTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }else{
            postOrderTraversal(treeNode.leftNode);
            postOrderTraversal(treeNode.rightNode);
            System.out.print(treeNode.data+"\t");
        }
    }

    public static void postOrderTraversalIterative(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if(curr.leftNode!=null){
                stack1.push(curr.leftNode);
            }
            if(curr.rightNode!=null){
                stack1.push(curr.rightNode);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().data+"\t");
        }
    }

    public void add(TreeNode currTreeNode,Integer data){
        if(root == null){
            TreeNode treeNode = new TreeNode(data);
            root = treeNode;
        }else{

            if(data <= currTreeNode.data){
                if(currTreeNode.leftNode != null){
                    add(currTreeNode.leftNode,data);
                }else{
                    currTreeNode.leftNode = new TreeNode(data);
                }
            }else{
                if(currTreeNode.rightNode != null){
                    add(currTreeNode.rightNode,data);
                }else{
                    currTreeNode.rightNode = new TreeNode(data);
                }
            }
        }
    }
}

class TreeNode {

    public Integer data;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(Integer data){
       this.data =  data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
