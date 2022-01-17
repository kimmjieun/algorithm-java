package 알고리즘기초1.a_자료구조1_참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

// 1918번 후위 표기식
public class boj_2_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = str.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        // 연산자별 우선순위 저장
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            // 알파벳은 바로 출력
            if ('A' <= ch && ch <= 'Z') sb.append(ch);
            else {
                switch (ch) {
                    case '(':
                        st.push(ch);
                        break;
                    case ')':
                        // 여는 괄호가 나올 때까지 출력
                        while (!st.isEmpty() && st.peek() != '(')
                            sb.append(st.pop());
                        if (!st.isEmpty() && st.peek() == '(') st.pop();
                        break;
                    default:
                        while (!st.isEmpty() && map.get(st.peek()) >= map.get(ch))
                            sb.append(st.pop());
                        st.push(ch);
                }
            }
        }

        // 남은 연산자들 모두 출력
        while (!st.isEmpty()) sb.append(st.pop());

        System.out.println(sb.toString());
    }
}
