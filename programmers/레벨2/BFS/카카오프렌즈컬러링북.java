package 레벨2.BFS;

import java.util.*;

public class 카카오프렌즈컬러링북 {
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, m, n, picture));
                    numberOfArea++;
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int  bfs(int x, int y, int m, int n, int[][] picture) {
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int tx = t[0];
            int ty = t[1];
            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (picture[tx][ty] == picture[nx][ny] && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        cnt++;
                    }
                }
            }

        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};

        System.out.println(Arrays.toString(solution(6, 4, picture)));
    }
}
