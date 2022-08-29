package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int n, m, map[][];
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
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
            // 틀렸을 때 출력해서 살펴봤다
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            bfs();
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

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }
        max = Math.max(cnt, max);

    }
}
