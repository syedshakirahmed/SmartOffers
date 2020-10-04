package com.practice.recursion;

import java.util.Arrays;

public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] arr = {9,8,6,5,4,3,2,1};
        sortSelection(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortSelection(int[] arr, int n) {
        int min = 0;
        int counter = 0;
        for (int i = 0;i<n-1;i++) {
            min = i;
            for (int j=i+1;j<n;j++) {
                counter++;
                if (arr[j] < arr[min]) {
                    int temp = arr[min];
                    arr[min] = arr[j];
                    arr[j] = temp;
              }
            }
        }
        System.out.println(counter);
    }
}
