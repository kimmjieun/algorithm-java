package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];

        // 구현
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                tetromino(i, j, 1, map[i][j]);
                visit[i][j] = false;
                plus(i, j);
//                check(i,j);
            }
        }

        System.out.println(max);
    }

    public static void tetromino(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    tetromino(nx, ny, depth + 1, sum + map[nx][ny]);
                    visit[nx][ny] = false;
                }
            }
        }
    }

    static void check(int y, int x) {
        if (y < n - 2 && x < m - 1)
            max = Math.max(max, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);

        if (y < n - 2 && x > 0)
            max = Math.max(max, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);

        if (y < n - 1 && x < m - 2)
            max = Math.max(max, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);

        if (y > 0 && x < m - 2)
            max = Math.max(max, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
    }


    static void plus(int x, int y) {
//        0과 m, n 사이
        if (x + 1 < n && y + 2 < m)
            max = Math.max(max, map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x][y + 2]);
        if (x - 1 >= 0 && y + 2 < m)
            max = Math.max(max, map[x][y] + map[x][y + 1] + map[x - 1][y + 1] + map[x][y + 2]);
        if (x + 2 < n && y + 1 < m)
            max = Math.max(max, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);
        if (x + 2 < n && y - 1 >= 0)
            max = Math.max(max, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y - 1]);
    }
}
