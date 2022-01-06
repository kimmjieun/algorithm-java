package 알고리즘기초1.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 1406번 에디터
public class boj_5_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.substring(i, i + 1));
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            switch (S) {
                case "L":
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "P":
                    left.push(st.nextToken());
                    break;
            }
        }


        // right 스택으로 옮기기
        while (!left.isEmpty())
            right.push(left.pop());

        // right 스택에 있는 값을 sb에 저장
        while (!right.isEmpty())
            sb.append(right.pop());

        System.out.println(sb.toString());
    }
}
