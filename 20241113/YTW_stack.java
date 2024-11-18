/* 20. Valid Parentheses */
// Runtime 6 ms Beats 7.92% Analyze Complexity 
// Memory 41.76 MB Beats 25.73%

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() <= 1)
            return false;

        Stack<Character> stack = new Stack<>();
        int sIndex = 0;

        do {

            stack.push(s.charAt(sIndex++));
            if (stack.size() == 1)
                continue;

            char c2 = stack.pop();
            char c1 = stack.pop();

            if (this.isMatch(c1, c2)) {
                // System.out.println(String.valueOf(c1) + String.valueOf(c2) + " is Match");
            } else {
                stack.push(c1);
                stack.push(c2);
            }

            // 아주 틀린 조합이면 return
            if (this.veryWrongMatch(c1, c2)) {
                return false;
            }
            // System.out.println(stack);
        } while (sIndex != s.length());

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean veryWrongMatch(char c1, char c2) {
        if (c1 == '(') {
            if (c2 == ']' || c2 == '}') {
                return true;
            }
        }

        if (c1 == '[') {
            if (c2 == ')' || c2 == '}') {
                return true;
            }
        }

        if (c1 == '{') {
            if (c2 == ']' || c2 == ')') {
                return true;
            }
        }

        return false;
    }

    private boolean isMatch(char c1, char c2) {

        if ((c1 == '(' && c2 == ')')
                || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']')) {
            return true;
        }
        return false;
    }
}