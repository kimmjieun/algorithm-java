package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836 {
    static int n, m, t;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m][2];// 0은 그람 없을 때, 1은 그람 있을 때
        int result = bfs(0, 0);
        if (result == -1) System.out.println("Fail");
        else System.out.println(result);

    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0, false));
        visit[x][y][0]=true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.count > t) break;
            if (node.x == n - 1 && node.y == m - 1) return node.count;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 그람 없을 때
                    if (!node.isGram) {
                        if (!visit[nx][ny][0] && map[nx][ny] == 0) {
                            q.add(new Node(nx, ny, node.count + 1, node.isGram));
                            visit[nx][ny][0] = true;
                        } else if (!visit[nx][ny][0] && map[nx][ny] == 2) {
                            q.add(new Node(nx, ny, node.count + 1, true));
                            visit[nx][ny][0] = true;
                        }
                    }
                    // 그람 있을 때
                    else {
                        if (!visit[nx][ny][1]) {
                            visit[nx][ny][1] = true;
                            q.add(new Node(nx, ny, node.count + 1, node.isGram));

                        }

                    }


                }
            }
        }

        return -1;
    }

    public static class Node {
        int x, y, count;
        boolean isGram;

        public Node(int x, int y, int count, boolean isGram) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isGram = isGram;
        }

    }

}
