package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963 {
    public static int w, h;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        count++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(count);


        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        map[x][y] = 0;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
