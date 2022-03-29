package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        boolean[] visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i <= n; i++) {
                if (map[x][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
