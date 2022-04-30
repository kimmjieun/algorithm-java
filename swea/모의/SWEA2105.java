package 모의;


import java.util.*;
import java.io.*;

public class SWEA2105 {
    static int[][] map;
    static boolean[][] visit;
    static boolean[] dessert;
    static int n;
    static int[] dx = {1, 1, -1, -1}; // 우하 좌하 좌상 우상
    static int[] dy = {1, -1, -1, 1};
    static int max;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            max = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 양 옆과 밑에 2칸 있어야 사각형 가능
            for (int i = 0; i < n - 2; i++) {
                for (int j = 1; j < n - 1; j++) {
                    visit = new boolean[n][n];
                    dessert = new boolean[101];
                    visit[i][j] = true;
                    dessert[map[i][j]] = true;
                    dfs(1, i, j, i, j, 0);

                }
            }

            if (max == 0)
                max = -1;
            sb.append("#" + t + " " + max + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cnt, int r, int c, int initR, int initC, int prevD) {
        for (int i = prevD; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;

            if (nx == initR && ny == initC && cnt > 2) {
                max = Math.max(max, cnt);
                return;
            }


            if (!visit[nx][ny] && !dessert[map[nx][ny]]) {
                visit[nx][ny] = true;
                dessert[map[nx][ny]] = true;
                dfs(cnt + 1, nx, ny, initR, initC, i);
                visit[nx][ny] = false;
                dessert[map[nx][ny]] = false;
            }

        }
    }

}
