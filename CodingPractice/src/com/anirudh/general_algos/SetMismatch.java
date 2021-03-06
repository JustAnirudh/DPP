package com.anirudh.general_algos;

/**
 * Created by paanir on 11/15/17.
 */
/*
645. Set Mismatch

The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of
the numbers in the set got duplicated to another number in the set, which results in repetition of one
number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number
occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
 */
public class SetMismatch {
    //O(n) time, O(1) space
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;

        //find actual sum
        int actSum = 0;
        for (int num : nums) {
            actSum += num;
        }

        //find dup element
        int dup = 0;
        for (int i = 0; i < len; ++i) {
            int curr = Math.abs(nums[i]);
            if (nums[curr - 1] < 0) { //the num[dup element] will be touched twice, hence checking if it already touched
                dup = curr;
                break;
            } else
                nums[curr - 1] *= -1;
        }

        //find expected number
        int expSum = len * (len + 1) / 2;
        int actSumWithoutDup = actSum - dup;
        int expElem = expSum - actSumWithoutDup;

        //return
        return new int[]{dup, expElem};

    }
}
