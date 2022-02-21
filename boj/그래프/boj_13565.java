package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13565 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][n];
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';// 문자를 숫자로
            }
        }

        // 첫째줄 큐에 넣기
        Queue<Dot> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (map[0][i] == 0) {
                q.add(new Dot(0, i));

            }
        }

        // bfs
        while (!q.isEmpty()) {
            Dot dot = q.poll();
            visit[dot.x][dot.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 0 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.add(new Dot(nx, ny));
                    }
                }
            }
        }

        // 전류 흐른지 안흐른지 판단
        if (checkCurrent()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static boolean checkCurrent() {
        for (int i = 0; i < n; i++) {
            if (visit[m - 1][i]) {
                return true;
            }
        }
        return false;
    }

    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
