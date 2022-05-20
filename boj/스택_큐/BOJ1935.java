package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        String operation = br.readLine();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < operation.length(); i++) {
            Character input = operation.charAt(i);

            if (input == '*') {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(b * a);
            } else if (input == '+') {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(b + a);
            } else if (input == '/') {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push((double) b / a);
            } else if (input == '-') {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(b - a);
            } else {
                stack.push((double) arr[input - 'A']);
            }
            System.out.println(stack);
        }

        System.out.format("%.2f", stack.pop());

    }
}
