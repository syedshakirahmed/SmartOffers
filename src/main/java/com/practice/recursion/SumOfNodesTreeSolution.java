package com.practice.recursion;

public class SumOfNodesTreeSolution {

    private static void findSumOfEachNode(Node node, int sum) {
        sum+=node.data;
        if(node.left != null)
            findSumOfEachNode(node.left,sum);
        if(node.right != null)
            findSumOfEachNode(node.right,sum);
        System.out.println("Sum of Node is "+sum);
    }
    public static void main(String[] args) {
        Node root = newNode(10);
        root.left = newNode(20);
        root.right = newNode(30);
        root.left.left = newNode(25);
        root.left.right = newNode(20);
        root.left.left.left = newNode(40);
        root.left.left.right = newNode(45);
        root.left.right.left = newNode(50);
        root.left.right.right = newNode(55);
        root.right.left = newNode(30);
        root.right.right = newNode(35);
        root.right.left.left = newNode(60);
        root.right.left.right = newNode(65);
        root.right.right.left = newNode(70);
        root.right.right.right = newNode(75);
        findSumOfEachNode(root,0);

    }

    public static Node newNode(int data) {
        Node node = new Node();
        node.data=data;
        node.left=node.right=null;
        return node;
    }
    static class Node {
        int data;
        Node left,right;
    }
}
