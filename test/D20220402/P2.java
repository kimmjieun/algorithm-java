package D20220402;

import java.util.ArrayList;
import java.util.List;

public class P2 {
    static int n, m;
    static List<int[]> list;
    static int ans;
    static Character[] alpha = {'G', 'R', 'L'};
    static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Character[][] map = {{'G', '?', 'L', 'L'}, {'R', '?', 'R', '?'}, {'R', 'R', 'R', 'L'}};
        n = 3;
        m = 4;
        // 5

//        Character[][] map = {{'?','?','G'}, {'R', 'G', 'L'}, {'L', 'L', '?'}};
//        n = 3;
//        m = 3;
//        // 2

//        Character[][] map = {{'G', 'G', '?'}};
//        n = 1;
//        m = 3;
//        // 3
        System.out.println(solution(map));
    }

    private static int solution(Character[][] map) {
        // ?표 개수세기
        // 백트래킹으로 ?표 채우기
        // 다 채웠으면 단지번호붙이기 군집 하기
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '?') {
                    int[] arr = {i, j};
                    list.add(arr);
                }
            }
        }

        ans = 0;
        back(0, map);
        return ans;

    }


    public static void back(int idx, Character[][] map) {
        if (idx == list.size()) {// ?표 다채웠으면 군집세기
            if (checkGroup(map)) {
                ans++;
            }
            return;
        }

        for (char a : alpha) {
            int x = list.get(idx)[0];
            int y = list.get(idx)[1];
            map[x][y] = a;
            back(idx + 1, map);
            map[x][y] = '?';
        }

    }

    public static boolean checkGroup(Character[][] map) {
        visit = new boolean[n][m];
        for (char a : alpha) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == a && !visit[i][j]) {
                        dfs(i, j, map);
                        count++;
                    }
                }
            }
            if (count >= 2) return false;
        }
        return true;
    }

    public static void dfs(int x, int y, Character[][] map) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visit[nx][ny]) continue;
            if (map[nx][ny] != map[x][y]) continue;

            dfs(nx, ny, map);
        }
    }


}
