package com.practice.recursion;

public class FibonacciDemo {
    public static void main(String[] args) {
        int prev = 1;
        int temp = 0;
        for (int i=1;i<20;) {
            System.out.println(i);
            temp = i;
            i = i + prev;
            prev = temp;
        }

    }

    private static int findFibonacci(int n) {
        if (n == 0)
           return 0;
        if (n < 2)
            return 1;
       return findFibonacci(n-1)+findFibonacci(n-2);
    }
}
