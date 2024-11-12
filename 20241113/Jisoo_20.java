/* 20. Valid Parentheses */
// Runtime 2 ms Beats 97.16% 
// Memory 41.33 MB Beats 80.25%

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char one = s.charAt(i);

            if (one == '(' || one == '{' || one == '[') {
                // 1. 열리는 괄호일 경우 무조건 push
                st.push(one);
            } else if (st.isEmpty()) {
                // 2. 닫히는 괄호인데 stack이 비었다 -> 틀린거임
                return false;
            } else {
                // 3. 닫히는 괄호일 경우 stack에서 하나 꺼내서 맞춰보기
                char top = st.pop();

                if ((one == ')' && top != '(') || (one == '}' && top != '{') || (one == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // 4. 끝났는데 stack에 남은 괄호가 있다 -> 틀린거
        return st.isEmpty();
    }
}