package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int value = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
                value *= 2;
            } else if (input.charAt(i) == '[') {
                stack.push('[');
                value *= 3;
            } else if (input.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (input.charAt(i - 1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;

            } else if (input.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (input.charAt(i - 1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }

//            System.out.println("value: "+value+" result "+result);
        }

        if (stack.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }

    }
}
