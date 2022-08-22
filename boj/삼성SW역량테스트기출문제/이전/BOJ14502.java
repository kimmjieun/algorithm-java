package 삼성SW역량테스트기출문제.이전;

import java.io.*;
import java.util.*;

public class BOJ14502 {
    static int n, m;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // 동 남 서 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0);
        System.out.println(max);

    }

    static void back(int depth) {

        if (depth == 3) {
            // 바이러스 터뜨리기
            virus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    back(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void virus() {
        // map 복제
        int[][] v = new int[n][m];
        for (int i = 0; i < n; i++) {
            v[i] = Arrays.copyOf(map[i], m);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }

        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (v[nx][ny] == 0) {
                        v[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        safeCount(v);
    }

    public static void safeCount(int[][] v) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);

    }
}
