package com.practice.vmware;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// i/p arr = [ 0, -1, 5, -3, 4, -5, 1, -2 ]
// [ 0, -1, 5 ] = 4
// [ 5, -3, 4 ] = 6
// [ 4, -5 ] = -1
// [ -1, 5, -3, 4, -5 ] = 0

// o/p : 6
public class SumOfArrays {

    static void printMaxSum(int[] arr)
    {
        int total = 0;
        int result = 0;
        if (arr.length==0) {
            System.out.print(" Print Output");
            return;
        }

        for (int i=0;i<arr.length;i++) {
            result = total >= result?total:result;
            int sum =arr[i];
            for (int j=i+1;j<arr.length;j++) {
                sum+=arr[j];
                total = sum > total?sum:total;
            }
        }

        System.out.print(" Total Sum "+result);

    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 0, -1, 5, -3, 4, -5, 1, -2,5,-8};
        printMaxSum( arr);
    }
}
