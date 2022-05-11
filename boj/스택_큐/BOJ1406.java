package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i) + "");
        }
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Character cmd = st.nextToken().charAt(0);
            if (cmd == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }

            } else if (cmd == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }

            } else if (cmd == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }

            } else if (cmd == 'P') {
                left.push(st.nextToken());
            }

        }


        // 출력방법 1
//        while (left.size() > 0) {
//            right.push(left.pop());
//        }
//
//        while (right.size() > 0) {
//            sb.append(right.pop());
//        }
//        System.out.println(sb);


        // 출력방법 2
        String leftS = "";
        String rightS = "";

        while (!left.isEmpty()) {
            leftS += left.pop();
        }

        while (!right.isEmpty()) {
            rightS += right.pop();
        }

        leftS = sb.append(leftS).reverse().toString();

        System.out.println(leftS + rightS);

//        System.out.println(sb.append(leftS+" "+rightS ));
    }
}
