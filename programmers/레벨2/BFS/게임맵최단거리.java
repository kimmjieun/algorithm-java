package 레벨2.BFS;


import java.util.*;

class 게임맵최단거리 {
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public Queue<int[]> q = new LinkedList<>();

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        q.add(new int[]{0, 0});
        bfs(maps);

        if (maps[n - 1][m - 1] == 1) return -1;
        else return maps[n - 1][m - 1];

    }

    public void bfs(int[][] maps) {

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {
                    if (maps[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        maps[nx][ny] = maps[x][y] + 1;
                    }
                }
            }
        }
    }
}

