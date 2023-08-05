package com.pivovarit.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class LetterCombinationsOfPhoneNumber {

    private static final Map<Character, List<Character>> PHONE_LETTERS = Map.of(
      '2', List.of('a', 'b', 'c'),
      '3', List.of('d', 'e', 'f'),
      '4', List.of('g', 'h', 'i'),
      '5', List.of('j', 'k', 'l'),
      '6', List.of('m', 'n', 'o'),
      '7', List.of('p', 'q', 'r'),
      '8', List.of('t', 'u', 'v'),
      '9', List.of('w', 'x', 'y'));

    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     */
    public static List<String> letterCombinations(String digits) {
        Objects.requireNonNull(digits);

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        searchCombinations("", digits, 0, result);
        return result;
    }

    private static void searchCombinations(String prefix, String digits, int index, List<String> combinations) {
        if (index >= digits.length()) {
            combinations.add(prefix);
            return;
        }

        for (var letter : PHONE_LETTERS.get(digits.charAt(index))) {
            searchCombinations(prefix + letter, digits, index + 1, combinations);
        }
    }
}
