package 알고리즘기초1.자료구조1;

import java.io.*;
import java.util.Stack;

public class boj_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String input = br.readLine() + "\n";
            for (char ch : input.toCharArray()) {
                if (ch == ' ' || ch == '\n') {
                    while (!s.isEmpty()) {
                        bw.write(s.pop());
                    }
                    bw.write(ch); // 공백
                } else {
                    s.push(ch);
                }
            }
        }
        bw.flush();
        return;
    }
}
