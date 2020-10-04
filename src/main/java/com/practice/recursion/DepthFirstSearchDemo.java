package com.practice.recursion;

public class DepthFirstSearchDemo {
    public static class Node {
        int data;
        Node left,right;
    }
    public static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right=null;
        return node;
    }
    public static void findDFS(Node node) {
        if (node == null)
            return;
        if(node.left == null && node.right == null)
            System.out.println(node.data);
        if (node.left != null)
            findDFS(node.left);
        if (node.right != null)
            findDFS(node.right);
    }
    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.left.left = newNode(4);
        root.right = newNode(3);
        root.right.left = newNode(5);
        root.right.left.left = newNode(6);
        root.right.left.right = newNode(7);
        root.right.right = newNode(8);
        root.right.right.left = newNode(9);
        root.right.right.right = newNode(10);
        findDFS(root);
    }
}
