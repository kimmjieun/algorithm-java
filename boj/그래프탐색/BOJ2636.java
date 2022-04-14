package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int[][] map;
    static int n, m;
    static int cheese;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cheese++;
            }
        }

        int cheeseCount = 0;
        int time = 0;
        while (cheese != 0) {
            cheeseCount = cheese;
            time++;
            visit = new boolean[n][m];
            bfs(); // 테두리만 0으로 바꿔줌
        }
        System.out.println(time);
        System.out.println(cheeseCount);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dx[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    if (map[nx][ny] == 0) {  // 공기를 만나면 큐에 삽입해서 계속 탐색하도록 한다, 테두리만 탐색가능
                        q.add(new int[]{nx, ny});
                    } else { // 치즈를 만나면 치즈 개수 줄이고
                        cheese--; // 치즈 개수 줄이고, 0으로 바꿔준다
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
