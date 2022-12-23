package com.practice.tree;

public class LowestCommonAncestor {


    public static void main(String[] args) {

        BinaryTree binaryTree =  new BinaryTree();
        binaryTree.add(BinaryTree.root,3);
        binaryTree.add(BinaryTree.root,5);
        binaryTree.add(BinaryTree.root,1);
        binaryTree.add(BinaryTree.root,-1);
        binaryTree.add(BinaryTree.root,10);
        binaryTree.add(BinaryTree.root,2);

        System.out.println("Tree created");

        System.out.println("Lowest common ancestor is " + lowestCommonAnc(BinaryTree.root,5,3).data);
    }

    //             3
    //         1        5
    //      -1    2        10

    public static TreeNode lowestCommonAnc(TreeNode root, Integer startNodeVal, Integer destNodeVal){

        if(root == null || root.data.equals(startNodeVal) || root.data.equals(destNodeVal)){

            return root;
        }else {

            TreeNode leftTreeNode = lowestCommonAnc(root.leftNode, startNodeVal, destNodeVal);
            TreeNode rightTreeNode = lowestCommonAnc(root.rightNode, startNodeVal, destNodeVal);

            if(leftTreeNode != null && rightTreeNode != null){
                return root;
            }else if(leftTreeNode != null){
                return leftTreeNode;
            }else{
                return rightTreeNode;
            }
        }
    }
}
