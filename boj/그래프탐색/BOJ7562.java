package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    public static int[][] map;
    public static int n;
    public static int[] dx = {2, 1, 2, 1, -2, -1, -2, -1};
    public static int[] dy = {-1, -2, 1, 2, -1, -2, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            bfs(sx, sy);
            if (sx == ex && sy == ey) {
                System.out.println(0);
            } else {
                System.out.println(map[ex][ey]);
            }

        }
    }

    public static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            for (int i = 0; i < 8; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }


}
