package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {1, -1, 0, 0};
//    static char[][] map;
//    static boolean[][] boundary;
//    static int count = 0;
//    static int n, m;
//    static Queue<int[]> q = new LinkedList<>();
//    static Queue<int[]> fire = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        map = new char[n][m];
//        for (int i = 0; i < n; i++) {
//            String str = br.readLine();
//            for (int j = 0; j < m; j++) {
//                map[i][j] = str.charAt(j);
//                if (map[i][j] == 'J')
//                    q.add(new int[]{i, j});
//                if (map[i][j] == 'F')
//                    fire.add(new int[]{i, j});
//            }
//        }
//
//        boundary = new boolean[n][m];
//        for (int i = 0; i < n; i++) {
//            boundary[0][i] = true;
//            boundary[n - 1][i] = true;
//        }
//        for (int i = 1; i < n - 1; i++) {
//            boundary[i][0] = true;
//            boundary[i][n - 1] = true;
//        }
//
//
//        while (true) {
//
//            if (moveJihoon()) {
//                break;
//            }
//
//            int fsize = fire.size();
//            for (int i = 0; i < fsize; i++) {
//                int[] t = fire.poll();
//                int tx = t[0];
//                int ty = t[1];
//
//                for (int j = 0; j < 4; j++) {
//                    int nx = tx + dx[j];
//                    int ny = ty + dy[j];
//                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != '#') {
//                        map[nx][ny] = 'F';
//                        fire.add(new int[]{nx, ny});
//                    }
//                }
//            }
//            if (q.isEmpty()) { // 지훈이가 이동할 수 있는 곳이 없으므로
//                System.out.println("IMPOSSIBLE");
//                break;
//            }
//
//        }
//
//    }
//
//    static boolean moveJihoon() {
//        int qsize = q.size();
//        for (int i = 0; i < qsize; i++) {
//            int[] t = q.poll();
//            int tx = t[0];
//            int ty = t[1];
//
//            if (boundary[tx][ty]) {
//                System.out.println(count + 1);
//                return true;
//            }
//
//            for (int j = 0; j < 4; j++) {
//                int nx = tx + dx[j];
//                int ny = ty + dy[j];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '.' && map[nx][ny] != '#') {
//                    map[nx][ny] = 'J';
//                    q.add(new int[]{nx, ny});
//                    count++;
//                }
//            }
//        }
//        return false;
//    }

//    // 메모리 초과
//    // 카운트 제거하고 map+1로 구현할 것
//    // visit 배열 추가할 것
//
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {1, -1, 0, 0};
//    static char[][] map;
//    static boolean[][] boundary;
//    static int[][] count;
//    static boolean[][] visit;
//    static int n, m;
//    static Queue<int[]> q = new LinkedList<>();
//    static Queue<int[]> fire = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        map = new char[n][m];
//        count = new int[n][m];
//        visit = new boolean[n][m];
//
//        for (int i = 0; i < n; i++) {
//            String str = br.readLine();
//            for (int j = 0; j < m; j++) {
//                map[i][j] = str.charAt(j);
//                if (map[i][j] == 'J') {
//                    count[i][j] = 1;
//                    q.add(new int[]{i, j});
//                }
//
//                if (map[i][j] == 'F')
//                    fire.add(new int[]{i, j});
//            }
//        }
//
//
//        boundary = new boolean[n][m];
//        for (int i = 0; i < n; i++) {
//            boundary[0][i] = true;
//            boundary[n - 1][i] = true;
//        }
//        for (int i = 1; i < n - 1; i++) {
//            boundary[i][0] = true;
//            boundary[i][n - 1] = true;
//        }
//
//
//        while (true) {
//
//            if (moveJihoon()) {
//                break;
//            }
//
//            int fsize = fire.size();
//            for (int i = 0; i < fsize; i++) {
//                int[] t = fire.poll();
//                int tx = t[0];
//                int ty = t[1];
//
//                for (int j = 0; j < 4; j++) {
//                    int nx = tx + dx[j];
//                    int ny = ty + dy[j];
//                    if (nx >= 0 && nx < n && ny >= 0 && ny < m
//                            && map[nx][ny] != '#' && !visit[nx][ny]) {
//                        visit[nx][ny] = true;
//                        map[nx][ny] = 'F';
//                        fire.add(new int[]{nx, ny});
//                    }
//                }
//            }
//            if (q.isEmpty()) { // 지훈이가 이동할 수 있는 곳이 없으므로
//                System.out.println("IMPOSSIBLE");
//                break;
//            }
//
//        }
//
//    }
//
//    static boolean moveJihoon() {
//        int qsize = q.size();
//        for (int i = 0; i < qsize; i++) {
//            int[] t = q.poll();
//            int tx = t[0];
//            int ty = t[1];
//
//            if (boundary[tx][ty]) {
//                System.out.println(count[tx][ty]);
//                return true;
//            }
//
//            for (int j = 0; j < 4; j++) {
//                int nx = tx + dx[j];
//                int ny = ty + dy[j];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < m
//                        && map[nx][ny] == '.' && map[nx][ny] != '#'
//                        && !visit[nx][ny]) {
//                    visit[nx][ny] = true;
//                    map[nx][ny] = 'J';
//                    count[nx][ny] = count[tx][ty] + 1;
//                    q.add(new int[]{nx, ny});
//                }
//            }
//        }
//        return false;
//    } // 57%에서 틀림


    // 아주 약간 바꾸기만 하면 됐다 맨처음에서
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visit;
    static int n, m;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> fire = new LinkedList<>();
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J') {
                    visit[i][j] = true;
                    q.add(new int[]{i, j});
                }
                if (map[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                }

            }
        }

        while (true) {
            time++;
            moveFire();

            if (moveJihoon()) {
                break;
            }

            if (q.isEmpty()) { // 지훈이가 이동할 수 있는 곳이 없으므로
                System.out.println("IMPOSSIBLE");
                break;
            }

        }

    }

    static boolean moveJihoon() {

        int qsize = q.size();
        for (int i = 0; i < qsize; i++) {
            int[] t = q.poll();
            int tx = t[0];
            int ty = t[1];

            if (tx == 0 || tx == n - 1 || ty == 0 || ty == m - 1) {
                System.out.println(time);
                return true;
            }

            for (int j = 0; j < 4; j++) {
                int nx = tx + dx[j];
                int ny = ty + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && map[nx][ny] != 'F' && map[nx][ny] != '#'
                        && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    static void moveFire() {
        int fsize = fire.size();
        for (int i = 0; i < fsize; i++) {
            int[] t = fire.poll();
            int tx = t[0];
            int ty = t[1];

            for (int j = 0; j < 4; j++) {
                int nx = tx + dx[j];
                int ny = ty + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && map[nx][ny] != '#' && map[nx][ny] != 'F') {
                    map[nx][ny] = 'F';
                    fire.add(new int[]{nx, ny});
                }
            }
        }
    }
}
