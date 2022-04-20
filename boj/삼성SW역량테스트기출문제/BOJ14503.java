package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int n, m, r, c, d;
    static int[][] map;
    static int count = 1;
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(count);
    }

    static void dfs(int x, int y, int dir) {
        map[x][y] = 2; // 청소했다
        for (int i = 0; i < 4; i++) {
            dir -= 1; // 왼쪽 방향으로 돌면서 탐색
            if (dir == -1) dir = 3;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0) { // 벽아니고 청소한 곳도 아니라면 청소하러 이동
                    count++;
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }

        // 반복문을 나왔다는 것은 주변에 더 이상 청소할 곳이 없다는 의미
        // 후진
        int d = (dir + 2) % 4; // 반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if (bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            dfs(bx, by, dir); // 후진할 때도 방향 유지
        }
    }

}
