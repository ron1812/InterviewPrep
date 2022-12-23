package com.practice.tree;

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.leftNode,root.rightNode);
    }

    public static boolean isMirror(TreeNode left,TreeNode right){
        if(left == null || right == null){
            return left == right;
        }

        if(left.data != right.data) return false;

        return isMirror(left.leftNode,right.rightNode)
                &&
                isMirror(left.rightNode,right.leftNode);
    }

    //              1
    //         2    |     2
    //      3    4  |   4     3
    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.rightNode = new TreeNode(2);

        root.leftNode.leftNode = new TreeNode(3);
        root.leftNode.rightNode = new TreeNode(4);

        root.rightNode.leftNode = new TreeNode(4);
        root.rightNode.rightNode = new TreeNode(3);


        System.out.println("Is symetric "+isSymmetric(root));

    }
}
