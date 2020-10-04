package com.practice.recursion;

public class PalindromeDemo {
    public static void main(String[] args){
        int num = 1231;

        String result = "Yes";
        try {
            findPalindrome(num,num);
        } catch (Exception e) {
            result = "No";
        }

        System.out.println(num+" Is Palindrome number? "+result);
        System.out.print(num+" Is PalindromeWithString number? "+findPalindromeWithString(num));
    }

    private static int findPalindrome(int num, int baseNum) throws Exception {
            if (num == 0){
                return  baseNum;
            } else {
                baseNum = findPalindrome(num/10,baseNum);
            }
            if (baseNum % 10 == num %10)
                return baseNum / 10;
            else
                throw new Exception();
        }
        private static String findPalindromeWithString(int num) {
        String s = ""+num;
        char[] chrArr = s.toCharArray();
        int n = chrArr.length-1;
        for (int i=0;i<=n;i++,n--) {
            if (chrArr[i] != chrArr[n])
                return "NO";
        }
        return "YES";
        }
    }
