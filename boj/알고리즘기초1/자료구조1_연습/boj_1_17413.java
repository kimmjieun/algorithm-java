package 알고리즘기초1.자료구조1_연습;

import java.io.*;
import java.util.Stack;

// 17413번 단어 뒤집기 2
public class boj_1_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // <> 안에 있는지 밖에 있는지 구분
        // 안이면 true, 밖이면 false
        boolean flag = false;

        String input = br.readLine() + '\n';
        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                flag = true;

                // 스택에 저장되어있는 거 다 pop 하면서 출력
                while (!s.isEmpty()) {
                    sb.append(s.pop());
                }

            } else if (ch == '>') {
                flag = false;
                sb.append(ch);
                continue;
            }

            // flag가 true일 경우, >를 만나기 전까지 그대로 입력
            if (flag == true) {
                sb.append(ch);

            } else if (flag == false) {
                // 해당 인덱스의 i 번째 문자가 공백일 경우, 모든 원소를 pop 수행후 공백 추가
                if (ch == ' ' || ch == '\n') {
                    while (!s.isEmpty()) {
                        sb.append(s.pop());
                    }
                    sb.append(' '); // 공백
                    continue;
                } else {
                    s.push(ch);
                }
            }

        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        System.out.println(sb);
    }
}
