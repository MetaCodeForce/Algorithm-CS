class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            // 여는 괄호는 다 받아준다
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            // 열지도 않았는데 닫아버리면 안됨
            } else if(stack.size() == 0) {
                return false;
            } else if(c == ')') { // 닫을거면 니 짝이 앞에 있나 봐야지
                if(stack.pop() != '(') return false;
            } else if(c == '}') { // 닫을거면 니 짝이 앞에 있나 봐야지
                if(stack.pop() != '{') return false;
            } else if(c == ']') { // 닫을거면 니 짝이 앞에 있나 봐야지
                if(stack.pop() != '[') return false;
            }
        }
        
        if (stack.size() > 0) {
            return false;
        }
        
        return true;
    }
}