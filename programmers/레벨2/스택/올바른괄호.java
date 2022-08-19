package 레벨2.스택;

import java.util.*;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }
        }


        // String ss ="";
        // while(!stack.isEmpty()){
        //     ss+=stack.pop();
        // }
        // for(int i=ss.length()-1;i>=0;i--){
        //       System.out.print(ss.charAt(i));
        // }


        if (stack.isEmpty()) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}
