package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedParenthesisTest {

    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final Set<Character> OPENERS = Set.of('(', '[', '{');

    private static final Map<Character, Character> PAIRS = Map.of(')', '(', ']', '[', '}', '{');

    @Test
    void shouldConfirmBalanced() {
        assertEquals(YES, isBalanced("[](){()}"));
        assertEquals(YES, isBalanced("()"));
        assertEquals(YES, isBalanced("({}([][]))[]()"));
        assertEquals(NO, isBalanced("}][}}(}][))]"));
        assertEquals(NO, isBalanced("{)[](}]}]}))}(())("));
        assertEquals(NO, isBalanced("([[)"));
    }

    public static String isBalanced(String s) {
        Stack<Character> tracker = new Stack<>();

        char[] charArray = s.toCharArray();
        for (char val : charArray) {
            if (OPENERS.contains(val)) {
                tracker.push(val);
            } else if (tracker.isEmpty() || PAIRS.get(val) != tracker.pop()) {
                return NO;
            }
        }

        return tracker.isEmpty() ? YES : NO;
    }
}
