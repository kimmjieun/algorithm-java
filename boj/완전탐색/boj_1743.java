package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1743 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        int max = Integer.MIN_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x - 1][y - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        System.out.println(max);

    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        q.add(new int[]{x, y});
        arr[x][y] = 0;
        while (!q.isEmpty()) {
            int[] dir = q.poll();
            int xx = dir[0];
            int yy = dir[1];
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return count++;
    }
}
