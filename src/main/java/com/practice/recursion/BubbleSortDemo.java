package com.practice.recursion;

import java.util.Arrays;

public class BubbleSortDemo {

    private static void sortBubble(int[] arr, int length) {
        int counter = 0;
        //int n = arr.length;
        for (int i=0;i<length-1;i++) {
            for (int j = 0; j < length-i- 1; j++) {
                counter++;
                System.out.println(arr[j] +">"+ arr[j + 1]);
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
            System.out.println("end of method "+counter);
    }

    public static void main(String[] args) {
        int[] arr = {9,8,6,5,4,3,2,1};
        sortBubble(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }


}
