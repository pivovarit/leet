package com.pivovarit.leet;

import java.util.Objects;

class MedianOfTwoSortedArrays {

    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * time-complexity O(m+n).
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = mergeTwoSortedArrays(nums1, nums2);

        return merged.length % 2 == 0
          ? (double) (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2
          : merged[merged.length / 2];
    }

    public static int[] mergeTwoSortedArrays(int[] array1, int[] array2) {
        Objects.requireNonNull(array1);
        Objects.requireNonNull(array2);
        if (array1.length == 0) {
            return array2;
        }
        if (array2.length == 0) {
            return array1;
        }
        int[] mergedArray = new int[array1.length + array2.length];
        int array1Index = 0;
        int array2Index = 0;
        int mergedArrayIndex = 0;

        while (array1Index < array1.length && array2Index < array2.length) {
            mergedArray[mergedArrayIndex++] = array1[array1Index] <= array2[array2Index]
              ? array1[array1Index++]
              : array2[array2Index++];
        }
        while (array1Index < array1.length) {
            mergedArray[mergedArrayIndex++] = array1[array1Index++];
        }
        while (array2Index < array2.length) {
            mergedArray[mergedArrayIndex++] = array2[array2Index++];
        }
        return mergedArray;
    }
}
