package 그래프탐색;

import java.util.*;
import java.io.*;

public class BOJ2644 {
    static int n, start, end;
    static int[][] map;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        d = new int[n + 1];// 촌수 저장 배열

        bfs(start);
        if (d[end] == 0)
            System.out.print(-1);
        else
            System.out.print(d[end]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == end) break;
            for (int i = 0; i <= n; i++) {
                if (d[i] == 0 && map[x][i] == 1) {
                    q.add(i);
                    d[i] = d[x] + 1;
                }
            }
        }

    }
}
