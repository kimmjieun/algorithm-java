package 레벨2;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }


    }
}
