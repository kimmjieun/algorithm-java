package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cloud {
    int x, y;

    public Cloud(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class BOJ21610 {
    static int answer;
    static int N, M;
    static int[][] map;
    static Cloud[] command;
    static boolean[][] visited;
    static Queue<Cloud> q;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        command = new Cloud[M];
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            command[i] = new Cloud(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        q = new LinkedList<>();
        q.add(new Cloud(N, 1));
        q.add(new Cloud(N, 2));
        q.add(new Cloud(N - 1, 1));
        q.add(new Cloud(N - 1, 2));

        for (int i = 0; i < M; ++i) {
            int dir = command[i].x - 1;
            int dist = command[i].y;

            answer = 0;
            move(dir, dist);
        }
        System.out.print(answer);
    }

    static void move(int dir, int dist) {
        //move
        Queue<Cloud> mvd = new LinkedList<>();
        while (!q.isEmpty()) {
            Cloud cur = q.poll();

            int mx = cur.x + (dx[dir] * dist);
            int my = cur.y + (dy[dir] * dist);

            while (!isValid(mx)) mx = change(mx);
            while (!isValid(my)) my = change(my);

            mvd.add(new Cloud(mx, my));
            map[mx][my]++;
            visited[mx][my] = true;
        }

        //copy
        while (!mvd.isEmpty()) {
            Cloud cur = mvd.poll();

            int cnt = 0;
            for (int idx = 1; idx <= 7; idx += 2) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if (!isValid(mx) || !isValid(my) || map[mx][my] < 1) continue;
                cnt++;
            }
            map[cur.x][cur.y] += cnt;
        }
        make();
    }

    static void make() {
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if ((map[i][j] >= 2) && !visited[i][j]) {
                    q.add(new Cloud(i, j));
                    map[i][j] -= 2;
                } else visited[i][j] = false;
                answer += map[i][j];
            }
        }
    }

    static boolean isValid(int x) {
        return x > 0 && x <= N;
    }

    static int change(int x) {
        return x < 1 ? x + N : x - N;
    }
}
