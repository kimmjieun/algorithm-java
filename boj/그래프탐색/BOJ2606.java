package 그래프탐색;

import java.util.*;
import java.io.*;

public class BOJ2606 {
    static int count = 0;
    static int[][] map;
    static int n;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        visit = new boolean[n + 1];
        bfs(1);
        System.out.print(count);
    }

    // 함수화
    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;
        while (!q.isEmpty()) {
            int tx = q.poll();
            for (int i = 1; i <= n; i++) {
                if (!visit[i] && map[tx][i] == 1) {
                    visit[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
    }

}
