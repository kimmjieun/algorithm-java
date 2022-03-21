package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {
    static int[][] arr;
    static boolean[] visit;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;

        }

        visit = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visit = new boolean[n + 1];
        bfs(v);

    }

    public static void dfs(int x) {
        System.out.print(x + " ");
        visit[x] = true;
        for (int i = 1; i <= n; i++) {
            if (arr[x][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }

    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;
        while (!q.isEmpty()) {
            x = q.poll();
            System.out.print(x + " ");
            for (int i = 1; i <= n; i++) {
                if (arr[x][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }


}
