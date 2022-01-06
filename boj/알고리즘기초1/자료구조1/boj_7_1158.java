package 알고리즘기초1.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1158번 요세푸스 문제
public class boj_7_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                q.add(q.poll());
            }

            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append('>');
        System.out.println(sb);

    }
}
