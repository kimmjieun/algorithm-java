package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5567 {
    public static int[][] map;
    public static boolean[] visit;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }


        visit = new boolean[n + 1];

        dfs(0, 1);

        int result = 0;
        for (int j = 2; j <= n; j++) {
            if (visit[j])
                result++;
        }
        System.out.println(result);
    }

    public static void dfs(int depth, int x) {
        visit[x] = true;
        if (depth == 2) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (map[x][i] == 1) {
                visit[i] = true;
                dfs(depth + 1, i);
            }
        }
    }
}
