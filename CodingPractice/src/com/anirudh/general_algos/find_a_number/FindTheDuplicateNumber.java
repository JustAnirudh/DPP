package com.anirudh.general_algos.find_a_number;

/**
 * Created by paanir on 1/20/17.
 */
/*
287. Find the Duplicate Number
Total Accepted: 51769
Total Submissions: 123698
Difficulty: Hard
Contributors: Admin
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
Note:
You must not modify the array (assume the array is read only).

>>You must use only constant, O(1) extra space.
>>Your runtime complexity should be less than O(n2).

There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {

    //or do as in SetMismatch
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;


    }
}