package com.pivovarit.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class ParseTreeStructure {

    /**
     * Parse and validate tree structure: (A(B(D(E)(F)(G)))(C))
     */
    public static TreeNode parse(String tree) {
        Objects.requireNonNull(tree);
        if (tree.isBlank() || tree.length() < 3 || tree.charAt(0) != '(' || tree.charAt(tree.length() - 1) != ')') {
            throw new IllegalArgumentException("not a tree");
        }

        var stripped = stripParentheses(tree);
        var init = new TreeNode(getValue(stripped));
        parseChildren(init, stripped.substring(1));
        return init;
    }

    public static void parseChildren(TreeNode node, String tree) {
        if (tree.isBlank()) {
            return;
        }
        int openCount = 0;
        int closedCount = 0;
        int lastIdx = -1;

        for (int i = 0; i < tree.length(); i++) {
            char current = tree.charAt(i);
            if (current == '(') {
                openCount++;
            }
            if (current == ')') {
                closedCount++;
            }

            if (closedCount > openCount) {
                throw new IllegalArgumentException("there are more closing braces than opening ones");
            }

            if (openCount == closedCount) {
                var stripped = stripParentheses(tree.substring(lastIdx + 1, i + 1));
                var childNode = new TreeNode(getValue(stripped));
                node.children.add(childNode);
                lastIdx = i;
                parseChildren(childNode, stripped.substring(1));
            }
        }

        if (openCount > closedCount) {
            throw new IllegalArgumentException("there are more opening braces than closing ones");
        }
    }

    public static class TreeNode {

        private final char value;

        private final List<TreeNode> children = new ArrayList<>();

        TreeNode(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(%s%s)".formatted(value, children.isEmpty()
              ? ""
              : children.stream().map(TreeNode::toString).collect(Collectors.joining()));
        }

    }
    public static String stripParentheses(String tree) {
        return tree.substring(1, tree.length() - 1);
    }

    public static char getValue(String tree) {
        return tree.charAt(0);
    }
}

