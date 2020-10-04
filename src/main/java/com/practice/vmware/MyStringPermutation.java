package com.practice.vmware;

public class MyStringPermutation {
    private static void findStringPermutations(String str, String res) {
        if (str.length() == 0) {
            System.out.println(res+" ");
            return;
        }
        for (int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);
            findStringPermutations(ros,res+ch);
        }
    }
    public static void main(String[] args){
        String str = "abca";
        findStringPermutations(str,"");
    }
}
