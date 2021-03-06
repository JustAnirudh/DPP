package com.anirudh.subarray_substring.string_manipulation;

/**
 * Created by paanir on 1/4/17.
 */
/*
214. Shortest Palindrome

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the
shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {

    private static boolean isPalindromeMine(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i)
            sb.insert(0, s.charAt(i));
        return s.equals(sb.toString());
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    //O(n^2)
    public static String shortestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) { //start from back
            String subs = s.substring(0, i + 1); //take the substring from 0 to current i
            if (isPalindrome(subs)) //if it is a palindrome, break
                break;
            sb.append(s.charAt(i)); //if the current substring is not a palindrome, append it to a stringbuilder and continue.
            // It will always stop at last character as a single letter is always a palindrome
        }
        return sb.toString() + s; //prepend the sb to the original string. sb already has the strings in reverse.
    }

    //----------------------------------------------------------------------------------------

    //KMP algo (find largest palindrome substring from starting from the beginning of the string)
    public String shortestPalindromeFaster(String s) { //ProgramCreek soln
        int left = 0;
        int right = s.length() - 1;

        while (right >= 0) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
            }
            right--;
        }

        if (left == s.length())
            return s;

        String suffix = s.substring(left);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindromeFaster(s.substring(0, left));
        return prefix + mid + suffix;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcd"));
    }
}
