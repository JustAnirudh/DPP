package com.anirudh.math;

/**
 * Created by paanir on 5/15/17.
 */
/*
365. Water and Jug Problem
You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available.
You need to determine whether it is possible to measure exactly z litres using these two jugs.

If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
Example 1: (From the famous "Die Hard" example)

Input: x = 3, y = 5, z = 4
Output: True
Example 2:

Input: x = 2, y = 6, z = 5
Output: False
 */
/*
from: https://leetcode.com/problems/water-and-jug-problem/#/solutions
Math solution - Java solution
This is a pure Math problem. We need the knowledge of number theory to cover the proof and solution. No idea why microsoft uses this problem in real interview.

The basic idea is to use the property of Bézout's identity and check if z is a multiple of GCD(x, y)

Quote from wiki:

Bézout's identity (also called Bézout's lemma) is a theorem in the elementary theory of numbers:

let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x
and y such that ax+by=d

In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by

every integer of the form ax + by is a multiple of the greatest common divisor d.
If a or b is negative this means we are emptying a jug of x or y gallons respectively.

Similarly if a or b is positive this means we are filling a jug of x or y gallons respectively.

x = 4, y = 6, z = 8.

GCD(4, 6) = 2

8 is multiple of 2

so this input is valid and we have:

-1 * 4 + 6 * 2 = 8

In this case, there is a solution obtained by filling the 6 gallon jug twice and emptying the 4 gallon jug once.
(Solution. Fill the 6 gallon jug and empty 4 gallons to the 4 gallon jug. Empty the 4 gallon jug. Now empty the remaining
two gallons from the 6 gallon jug to the 4 gallon jug. Next refill the 6 gallon jug. This gives 8 gallons in the end)

See wiki:

Bézout's identity
 */
public class WaterAndJug {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        if (x == z || y == z || x + y == z)
            return true;
        return z % getGCD(x, y) == 0;
    }

    public int getGCD(int x, int y) {
        if (x == 0)
            return y;
        else
            return getGCD(y % x, x);
    }
}
