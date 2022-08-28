package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20058 {
    public static int N, Q;
    static int[][] map;
    static int[] L;
    static int max = 0;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        L = new int[Q];
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        // 시뮬
        for (int i = 0; i < Q; i++) {
            // 부분 격자 나누기 L[i]
            map = divide(L[i]);
            // 얼음있는 칸 3개이상 인접 안하면=특정칸 인접 얼음칸 3개미만 얼음양 1줄어듬
            map = melt();
        }


        // 남아있는 얼음 합, 가장 큰 덩어리가 차지하는 칸의 개수
        visit = new boolean[N][N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
                if (map[i][j] > 0 &&!visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sum);
        System.out.println(max);


    }

    public static int[][] divide(int L) {
        int[][] tmp = new int[N][N];
        L = (int) Math.pow(2, L);
        for (int i = 0; i < N; i += L) {
            for (int j = 0; j < N; j += L) {
                // 시계방향으로 90도 회전하기
                rotate(i, j, tmp, L);
            }
        }
        return tmp;
    }


    public static void rotate(int x, int y, int[][] tmp, int L) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                tmp[x + i][y + j] = map[x + L - 1 - j][y + i];
            }
        }
    }

    public static int[][] melt() {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            tmp[i] = Arrays.copyOf(map[i], N);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                if (map[i][j] == 0)
                    continue;
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (map[nx][ny] > 0) {
                            cnt++;
                        }
                    }
                }

                if (cnt < 3) tmp[i][j]--;
            }
        }
        return tmp;
    }


    public static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visit[a][b] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visit[nx][ny] && map[nx][ny] > 0) {
                        q.add(new int[]{nx, ny});
                        cnt++;
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        max = Math.max(max, cnt);
    }
}
