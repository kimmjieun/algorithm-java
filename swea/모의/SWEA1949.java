package 모의;


import java.util.*;
import java.io.*;

public class SWEA1949 {
    public static int N, K;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            max = Integer.MIN_VALUE;
            // 최대 봉우리 높이 구하기
            int maxBong = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxBong = Math.max(maxBong, map[i][j]);
                }
            }

            // 최대 봉우리높이인 위치 구하
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (maxBong == map[i][j]) {
                        list.add(new int[]{i, j});
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k <= K; k++) {
                        map[i][j] -= k;
                        // 최대 봉우리에서 dfs 실행하기
                        for (int h = 0; h < list.size(); h++) {
                            dfs(1, list.get(h)[0], list.get(h)[1]);
                        }
                        map[i][j] += k;
                    }

                }
            }
            System.out.println("#" + t + " " + max);
        }

    }

    public static void dfs(int cnt, int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] < map[x][y]) {
                    dfs(cnt + 1, nx, ny);
                }
            }
        }
        max = Math.max(max, cnt);
    }

}
