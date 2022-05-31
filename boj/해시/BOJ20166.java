package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ20166 {
//    static char[][] map;
//    static int cnt, n, m;
//    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
//    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        map = new char[n][m];
//
//        for (int i = 0; i < n; i++) {
//            String s = br.readLine();
//            for (int j = 0; j < m; j++) {
//                map[i][j] = s.charAt(j);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        while (k-- > 0) {
//            cnt = 0;
//            String s = br.readLine();
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (s.charAt(0) == map[i][j]) {
//                        dfs(i, j, 1, s, s.charAt(0) + "");
//                    }
//                }
//            }
//            sb.append(cnt).append("\n");
//        }
//        System.out.println(sb);
//    }
//
//    static void dfs(int x, int y, int depth, String s, String sum) {
//        if (depth == s.length()) {
//            if (s.equals(sum)) {
//                cnt++;
//            }
//            return;
//        }
//        for (int i = 0; i < 8; i++) {
//            int nx = (n + dx[i] + x) % n;
//            int ny = (m + dy[i] + y) % m;
////            if(nx>=0 && nx<n && ny>=0 &&ny<m){ // 틀림 나머지
//            if (s.charAt(depth) == map[nx][ny]) {
//                dfs(nx, ny, depth + 1, s, sum + s.charAt(depth));
//            }
////            }
//        }
//    }

    static char[][] map;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static HashMap<String, Integer> hash = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                hash.put(map[i][j] + "", hash.getOrDefault(map[i][j] + "", 0) + 1);
                dfs(i, j, 1, map[i][j] + "");
            }
        }
        while (k-- > 0) {
            String s = br.readLine();
            sb.append(hash.getOrDefault(s, 0)).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int depth, String s) {
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < 8; i++) {
            int nx = (n + dx[i] + x) % n;
            int ny = (m + dy[i] + y) % m;
            String newStr = s + map[nx][ny] + "";
            hash.put(newStr, hash.getOrDefault(newStr, 0) + 1);
            dfs(nx, ny, depth + 1, newStr);
        }
    }
}
