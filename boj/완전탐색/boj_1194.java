package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1194 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][][] visit;
    static Node start;
    static int n, m, ans = Integer.MAX_VALUE;

    static class Node {
        int row;
        int col;
        int cnt;
        int key;

        public Node(int row, int col, int cnt, int key) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[64][n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0')
                    start = new Node(i, j, 0, 0);
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start.row, start.col, 0, 0));
        visit[0][start.row][start.col] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            int cnt = node.cnt;
            int key = node.key;

            if (map[row][col] == '1')
                return cnt;
            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if (isBoundary(nx, ny) && map[nx][ny] != '#' && !visit[key][nx][ny]) {
                    if (map[nx][ny] == '.' || map[nx][ny] == '0' || map[nx][ny] == '1') {
                        visit[key][nx][ny] = true;
                        q.offer(new Node(nx, ny, cnt + 1, key));
                    } else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                        int newKey = 1 << (map[nx][ny] - 'a');
                        newKey = newKey | key;
                        if (!visit[newKey][nx][ny]) {
                            visit[key][nx][ny] = true;
                            visit[newKey][nx][ny] = true;
                            q.offer(new Node(nx, ny, cnt + 1, newKey));
                        }
                    } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                        int door = 1 << (map[nx][ny] - 'A');
                        if ((key & door) > 0) {
                            visit[key][nx][ny] = true;
                            q.offer(new Node(nx, ny, cnt + 1, key));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static boolean isBoundary(int row, int col) {
        return (row >= 0 && row < n) && (col >= 0 && col < m);
    }
}
