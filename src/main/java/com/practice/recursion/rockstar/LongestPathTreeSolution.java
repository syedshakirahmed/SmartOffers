package com.practice.recursion.rockstar;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;
class LongestPathTreeSolution {
    static List<Integer> previousData = new ArrayList<>();
    static int result = 0;
    static int total = 0;

    public static int solution(Tree T, int sum) {
        // write your code in Java SE 8
        if(!previousData.contains(T.x)) {
            previousData.add(T.x);
            sum++;
            if (T.left != null) {
                solution(T.left,sum);
                //result = sum > result?sum:result;
            }
            if (T.right != null) {
                solution(T.right,sum);
                //result = sum > result?sum:result;
            }
            previousData.remove(new Integer(T.x));
            result = sum > result?sum:result;
        }
        return result;
    }
    static class Tree {
        int x;
        Tree left;
        Tree right;
    }
    public static Tree newNode(int data) {
        Tree tree = new Tree();
        tree.x = data;
        tree.left=tree.right=null;
        return tree;
    }

    public static void main(String[] arg) {
        Tree root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(3);
        root.left.right = newNode(6);
        root.left.left.left = newNode(2);
        root.right.left = newNode(3);
        root.right.right = newNode(1);
        root.right.right.left = newNode(5);
        root.right.right.right = newNode(6);
        System.out.println("Finding the longest path "+solution(root,0));
        Tree root2 = newNode(1);
        root2.left = newNode(2);
        root2.right = newNode(2);
        root2.left.left = newNode(1);
        root2.left.right = newNode(2);
        root2.right.left = newNode(4);
        root2.right.right = newNode(1);
        result = 0;
        System.out.println("Finding the longest path "+solution(root2,0));
        Tree root3 = newNode(1);
        root3.right = newNode(2);
        root3.right.left = newNode(1);
        root2.right.right = newNode(1);
        root2.right.left.left = newNode(4);
        result = 0;
        System.out.println("Finding the longest path "+solution(root3,0));

    }

}