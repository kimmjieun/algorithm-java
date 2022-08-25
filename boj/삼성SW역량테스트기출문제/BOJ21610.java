package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21610 {
    public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n - 1, 0});
        q.add(new int[]{n - 1, 1});
        q.add(new int[]{n - 2, 0});
        q.add(new int[]{n - 2, 1});


        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 방향
            int s = Integer.parseInt(st.nextToken()); // 거리

            Queue<int[]> waterplus = new LinkedList<>();

            boolean[][] visit = new boolean[n][n];

            // 구름 이동
            while (!q.isEmpty()) {
                int[] t = q.poll();
                int nx = (n * s + t[0] + s * dx[d - 1]) % n;
                int ny = (n * s + t[1] + s * dy[d - 1]) % n;
                // 이동한 구름 물의 양 1 증가
                map[nx][ny]++;
                waterplus.add(new int[]{nx, ny});
                visit[nx][ny] = true;


                // 구름 모두 사라짐
            }

//            for (int k = 0; k < n; k++) {
//                System.out.println(Arrays.toString(map[k]));
//            }
//            break;


            // 물복사 마법 시전
            // 대각선 방향 거리 1인  칸에 물있는 바구니수만큼 물의 양
            while (!waterplus.isEmpty()) {
                int[] t = waterplus.poll();
                int cnt = 0;
                for (int j = 1; j < 8; j += 2) {
                    int nx = t[0] + dx[j];
                    int ny = t[1] + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (map[nx][ny] > 0) {
                            cnt++;
                        }
                    }
                }

                map[t[0]][t[1]] += cnt;
            }

//
//            for (int k = 0; k < n; k++) {
//                System.out.println(Arrays.toString(map[k]));
//            }
//            break;

            // 물의 양 2 이상인 칸 구름 생성, 물의양 2 감소 - 구름 사라진 칸 제외
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    // 구름 사라진칸 제외
                    if (!visit[k][j] && map[k][j] >= 2) {
                        q.add(new int[]{k, j});
                        map[k][j] -= 2;
                    }

                }
            }

//            for (int k = 0; k < n; k++) {
//                System.out.println(Arrays.toString(map[k]));
//            }
//            System.out.println();

        }

        // 물의양 출력
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);

    }
}
