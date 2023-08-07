package com.pivovarit.leet;

import java.util.Objects;

class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"foo", "food"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        Objects.requireNonNull(strs);

        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }

            }
        }

        return strs[0];
    }
}
