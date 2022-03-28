package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3184 {
    public static int r, c;
    public static Character[][] map;
    public static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int oo, vv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new Character[r][c];
        visit = new boolean[r][c];


        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(oo + " " + vv);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;
        int o = 0, v = 0;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (map[tmp[0]][tmp[1]] == 'o') {
                o++;
            }
            if (map[tmp[0]][tmp[1]] == 'v') {
                v++;
            }
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != '#' && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        if (o > v) {
            oo += o;
        } else {
            vv += v;
        }
    }
}
