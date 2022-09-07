package 레벨2.스택;

import java.util.*;

public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;

        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            String newS = "";

            char tmp = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = tmp;
            // System.out.println(Arrays.toString(arr));
            if (isCorrect(arr)) answer++;

        }
        return answer;
    }

    public boolean isCorrect(char[] arr) {
        Stack<Character> s = new Stack<>();
        for (char c : arr) {
            if (s.isEmpty()) {
                s.push(c);
            } else {
                if ((s.peek() == '(' && c == ')') ||
                        s.peek() == '{' && c == '}' ||
                        s.peek() == '[' && c == ']') {

                    s.pop();
                } else {
                    s.push(c);
                }
            }
        }

        if (s.isEmpty()) {
            // System.out.println("true");
            return true;
        } else {
            // System.out.println("false");
            return false;
        }

    }
}
