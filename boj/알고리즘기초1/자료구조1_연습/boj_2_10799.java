package 알고리즘기초1.자료구조1_연습;


import java.io.*;
import java.util.Stack;

// 10799번 쇠막대기
public class boj_2_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();

                if (input.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }

        }

        bw.write(result + "\n");
        bw.flush();
        bf.close();
        bw.close();
    }
}
