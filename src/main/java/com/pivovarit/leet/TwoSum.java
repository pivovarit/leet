package com.pivovarit.leet;

import java.util.HashMap;
import java.util.NoSuchElementException;

class TwoSum {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * <p>
     * Time-complexity: O(n)
     * Space-complexity: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        var numToIndex = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (numToIndex.containsKey(diff)) {
                return new int[]{numToIndex.get(diff), i};
            }

            numToIndex.put(nums[i], i);
        }

        throw new NoSuchElementException("No two sum solution");
    }
}
