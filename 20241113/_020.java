package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _020 {
    public static void main(String[] args) {

        /*
            Example 1:
            Input: s = "()"
            Output: true

            Example 2:
            Input: s = "()[]{}"
            Output: true

            Example 3:
            Input: s = "(]"
            Output: false

            Example 4:
            Input: s = "([])"
            Output: true
        */
        String s = "()[]{}";
        boolean result = solution(s);
        System.out.println(result);
    }

    public static boolean solution(String s){
        boolean result = true;
        Stack<String> stackStr = new Stack<>();

        // stack element push
        for (int i = 0; i < s.length(); i++) {
            stackStr.push(String.valueOf(s.charAt(i)));
        }

        // 기본 예외처리
        // 1. 길이가 홀수이면 false 반환
        if(stackStr.size() % 2 != 0) {
            //System.out.println("길이가 홀수이면 false 반환");
            return false;
        // 2. 맨 위 요소가 닫는 요소인지 확인
        } else if (!String.valueOf(stackStr.peek()).equals("}")
                && !String.valueOf(stackStr.peek()).equals(")")
                && !String.valueOf(stackStr.peek()).equals("]")) {
            return false;
        }

        // 여는 갯수와 닫는 갯수
        // int open, close
        int open1 = 0;
        int open2 = 0;
        int open3 = 0;
        int close1 = 0;
        int close2 = 0;
        int close3 = 0;
        for (int i = 0; i < stackStr.size(); i++) {
            if(stackStr.elementAt(i).equals("(")){
                open1++;
            } else if(stackStr.elementAt(i).equals("[")) {
                open2++;
            } else if(stackStr.elementAt(i).equals("{")) {
                open3++;
            } else if(stackStr.elementAt(i).equals(")")) {
                close1++;
            } else if(stackStr.elementAt(i).equals("]")) {
                close2++;
            } else if(stackStr.elementAt(i).equals("}")) {
                close3++;
            }
        }

        if(open1 != close1 || open2 != close2 || open3 != close3){
            return false;
        }

        int cycle = stackStr.size()/2;

        for (int i = 0; i <= cycle; i++) {
            if(result==false){
                break;
            }
            for (int j = i+1; j < stackStr.size(); j = j+2) {
                System.out.println("i : " + i + " : "+ stackStr.elementAt(i) + ", j : " + j + " : " + stackStr.elementAt(j));
                System.out.println(stackStr);
                System.out.println();
                if(stackStr.elementAt(i).equals("(")
                    || stackStr.elementAt(i).equals("[")
                    || stackStr.elementAt(i).equals("{")) {
                        if((stackStr.elementAt(i).equals("(") && stackStr.elementAt(j).equals(")"))
                            || (stackStr.elementAt(i).equals("{") && stackStr.elementAt(j).equals("}"))
                            || (stackStr.elementAt(i).equals("[") && stackStr.elementAt(j).equals("]"))) {
                        result = true;
                        //stackStr.remove(j);
                        break;
                    } else {
                        result = false;
                    }
                } else {
                    //result = false;
                    break;
                }
            }
        }



        /*
        for (int i = 0; i < stackStr.size(); i++) {
            System.out.println("stackStr : " + stackStr.elementAt(i) + " <-> peek : " + stackStr.peek());

            if((stackStr.elementAt(i).equals("(") && stackStr.peek().equals(")"))
                || (stackStr.elementAt(i).equals("{") && stackStr.peek().equals("}"))
                || (stackStr.elementAt(i).equals("[") && stackStr.peek().equals("]"))) {
                stackStr.pop();
                result = true;
            } else {
                return false;
            }
        }
        */



        return result;
    }
}
