package DM20220402;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 해결안됨

public class P2 {
    public static List<int[]> list;
    public static int ans;
    public static Character[] alpha = {'G', 'R', 'L'};
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n, m;
    public static boolean[][] visit;

    public static void main(String[] args) {
        Character[][] map = {{'G', '?', 'L', 'L'}, {'R', '?', 'R', '?'}, {'R', 'R', 'R', 'L'}};
        n = 3;
        m = 4;
        System.out.println(solution(map));
    }

    public static int solution(Character[][] map) {
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '?') {
                    int[] nums = {i, j};
                    list.add(nums);
                }
            }
        }

//        for(int[] a : list){
//            System.out.println(a[0]+" ddd");
//            System.out.println(a[1]+" sss");
//        }

        ans =0;
        back(0, map);

        return ans;

    }

    public static void back(int idx, Character[][] map) {

        if (idx == list.size() - 1) {
            if (checkGroup(map)) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(map[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println("***");
                ans++;
            }
            return;
        }


        for (Character a : alpha) {
            int x = list.get(idx)[0];
            int y = list.get(idx)[1];
            map[x][y] = a;
            back(idx + 1, map);
            map[x][y] = '?';
        }
    }

    public static boolean checkGroup(Character[][] map) {
        visit = new boolean[n][m];
        for (Character a : alpha) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == a && !visit[i][j]) {
                        cnt++;
                        dfs(i, j, map);
                    }
                }
            }
            if (cnt >= 2) return false;
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
            if (map[x][y] != map[nx][ny]) continue;
            dfs(nx, ny, map);

        }
    }
}
