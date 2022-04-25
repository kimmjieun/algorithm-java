package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class BOJ21610 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static boolean[][] visit;
    static Queue<Cloud> clouds = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new Cloud(n - 1, 0));
        clouds.add(new Cloud(n - 1, 1));
        clouds.add(new Cloud(n - 2, 0));
        clouds.add(new Cloud(n - 2, 1));

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            step12(d, s);
            stept34();
            step5();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);

    }

    private static void step12(int d, int s) {
        // 구름 이동, 구름 칸 물의 양 1 증가
        for (Cloud cloud : clouds) {
            cloud.x = (n + cloud.x + dx[d] * (s % n)) % n;
            cloud.y = (n + cloud.y + dy[d] * (s % n)) % n;
            map[cloud.x][cloud.y]++;
        }

    }

    private static void stept34() {
        // 구름제거, 물복사 버그마법 시전 (대각선에 물바구니 있으면 그만큼 증가)
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();
            int cnt = 0;

            visit[cloud.x][cloud.y] = true;
            for (int i = 1; i <= 7; i += 2) {
                int nx = cloud.x + dx[i];
                int ny = cloud.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] >= 1)
                        cnt++;
                }

            }
            map[cloud.x][cloud.y] += cnt;

        }

    }

    private static void step5() {
        // 물의양 2이상인 모든칸 구름 생기고 물양 2줄어들기 (단, 3에서 구름이 사라진 칸 무시)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }
        visit = new boolean[n][n]; // 위치가 왜 여길까 ?

    }

    public static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
