package 레벨2.다시풀문제;

import java.util.*;

public class 괄호변환_구현 {
    int index = 0;

    public String solution(String p) {
        String answer = "";
        // 1. 빈 문자열 반환
        if (p.equals("")) return p;

        // 2. 균형잡힌 괄호 문자열 u, v로 분리
        boolean isCorrect = divide(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        // 3. u가 올바른 문자열이면, v에 대해 처리
        if (isCorrect) return u + solution(v);

        // 4.
        StringBuilder sb = new StringBuilder();
        sb.append('('); // 4-1
        sb.append(solution(v)); // 4-2
        sb.append(')'); // 4-3

        // 4-4
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(')
                sb.append(')');
            else {
                sb.append('(');
            }
        }

        return sb.toString();

    }

    private boolean divide(String p) {
        boolean isCorrect = true; // 올바른 괄호 문자열인가
        int left = 0, right = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '(') {
                stack.push('(');
                left++;
            } else {
                right++;
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                    isCorrect = false;
                }
            }
            if (left == right) {
                index = i + 1;
                break;
            }
        }

        return isCorrect;
    }
}
