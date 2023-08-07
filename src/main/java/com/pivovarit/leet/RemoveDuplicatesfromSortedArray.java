package com.pivovarit.leet;

import java.util.Objects;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 */
class RemoveDuplicatesfromSortedArray {

    public static int removeDuplicates(int[] nums) {
        Objects.requireNonNull(nums);
        if (nums.length == 0) {
            return 0;
        }

        int lastIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[lastIndex]) {
                lastIndex++;
                nums[lastIndex] = nums[i];
            }
        }
        return lastIndex + 1;
    }
}
