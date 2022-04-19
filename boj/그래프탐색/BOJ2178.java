package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    public static int n, m;
    public static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0'; // 문자를 숫자로 만드는 법  char -> int
            }
        }

        visit = new boolean[n][m];
        bfs(0, 0);
//        bfs2(0, 0);
        System.out.println(map[n - 1][m - 1]);

    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int tx = t[0];
            int ty = t[1];
            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = map[tx][ty] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }

            }
        }
    }

    // visit 배열로 방문여부 판단했지만 없어도 됨
    static void bfs2(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = map[tmp[0]][tmp[1]] + 1; // 이걸로 하기
                    }
                }
            }
        }
    }
}
