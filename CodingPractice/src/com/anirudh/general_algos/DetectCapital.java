package com.anirudh.general_algos;

/**
 * Created by paanir on 10/7/17.
 */
/*
520. Detect Capital
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0)
            return true;
        if (Character.isUpperCase(word.charAt(0))) {
            //either all uppercase or all lowercase
            if (word.length() == 1)
                return true;
            boolean secondLUC = Character.isUpperCase(word.charAt(1));
            if (secondLUC) {
                //all should be upper case
                for (int i = 2; i < word.length(); ++i) {
                    if (!Character.isUpperCase(word.charAt(i)))
                        return false;
                }
            } else { //all should be lower case
                for (int i = 2; i < word.length(); ++i) {
                    if (Character.isUpperCase(word.charAt(i)))
                        return false;
                }
            }
        } else { //no letter should be upper case
            for (int i = 1; i < word.length(); ++i) {
                if (Character.isUpperCase(word.charAt(i)))
                    return false;
            }
        }
        return true;
    }
}
