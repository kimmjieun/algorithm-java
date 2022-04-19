package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                    map[i][j] = 0;

                }
            }
        }

        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] || map[i][j] == 0)
                    System.out.print(map[i][j] + " ");
                else
                    System.out.print("-1 ");
            }
            System.out.println();
        }


    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            int tx = tmp[0];
            int ty = tmp[1];
            visit[tx][ty] = true;
            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visit[nx][ny] && map[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        map[nx][ny] = map[tx][ty] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}
