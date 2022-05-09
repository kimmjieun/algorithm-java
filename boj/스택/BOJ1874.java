package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> s = new Stack<>();


        for (int i = 1; i <= n; i++) {

            s.push(i);
            sb.append("+").append("\n");

            while (!q.isEmpty() && !s.isEmpty() && s.peek().equals(q.peek())) {
//            while (!q.isEmpty() && !s.isEmpty() && s.peek()==q.peek()) {
                s.pop();
                q.poll();
                sb.append("-").append("\n");
            }


        }
        if (s.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }


}
