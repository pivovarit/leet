package com.pivovarit.leet;

import java.util.Objects;

class LongestPalindromicSubstring {

    /**
     * Given a string string, return the longest
     * palindromic
     * <p>
     * 1 <= string.length <= 1000
     *
     * time-complexity: O(n^2)
     * space-complexity: O(n^2)
     *
     * @param string consist of only digits and English letters
     */
    public static String longestPalindrome(String string) {
        Objects.requireNonNull(string);

        if (string.length() == 1) {
            return string;
        }

        var palindromeMatrix = initializePalindromeMatrix(string);
        int start = 0;
        int maxLength = 1;

        for (int i = string.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < string.length(); j++) {
                if (sameCharacters(string, i, j)) {
                    if (hasOnlyTwoCharacters(j, i) || palindromeMatrix[i + 1][j - 1]) {
                        palindromeMatrix[i][j] = true;
                        if (maxLength < j - i + 1) {
                            maxLength = j - i + 1;
                            start = i;
                        }
                    }
                }
            }
        }
        return string.substring(start, start + maxLength);
    }

    private static boolean sameCharacters(String s, int i, int j) {
        return s.charAt(i) == s.charAt(j);
    }

    private static boolean hasOnlyTwoCharacters(int j, int i) {
        return j - i == 1;
    }

    private static boolean[][] initializePalindromeMatrix(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        return dp;
    }
}
