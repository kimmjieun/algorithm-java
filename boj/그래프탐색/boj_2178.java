package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {
    public static int n, m;
    public static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0'; // 문자를 숫자로 만드는 법
            }
        }
        int count = 0;
        boolean[][] visit = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
//            count++;
//            if (tmp[0] == n - 1 && tmp[1] == m - 1) {
//                break;
//            }
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        arr[nx][ny] = arr[tmp[0]][tmp[1]] + 1; // 이걸로 하기
                    }
                }
            }
        }
        System.out.println(arr[n - 1][m - 1]);

    }
}
