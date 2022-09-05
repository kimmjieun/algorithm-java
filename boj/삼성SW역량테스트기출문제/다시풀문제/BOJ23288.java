package 삼성SW역량테스트기출문제.다시풀문제;

import java.util.*;
import java.io.*;

public class BOJ23288 {

    static int N, M, K, dir, cur_x, cur_y, total, point;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dy = {1, 0, -1, 0};
    static int[] dice = {2, 4, 1, 3, 5, 6}; //??

    //   1
    // 2 3 4
    //   5
    //   6-아랫면
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        total = 0;
        dir = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cur_x = 0;
        cur_y = 0;
        for (int i = 0; i < K; i++) {
            // 이동 방향으로 갈 수 있는지
            isAvailable();

            // 이동하기
            move();

            // 점수 획득하기
            point = 1;
            bfs();
            total += map[cur_x][cur_y] * point;
        }
        System.out.println(total);
    }

    // 주사위 이동방향으로 굴리기
    public static void isAvailable() {
        int nx = cur_x + dx[dir];
        int ny = cur_y + dy[dir];

        if (nx < 0 && dir == 3) {  // 북쪽으로 가야하는데 범위를 초과할 떄
            dir = 1;// 남쪽으로 변환
        }
        if (nx >= N && dir == 1) {  // 남쪽으로 가야하는데 범위를 초과할 떄
            dir = 3;// 북쪽으로 변환
        }
        if (ny < 0 && dir == 2) {  // 서쪽으로 가야하는데 범위를 초과할 떄
            dir = 0;// 동쪽으로 변환
        }
        if (ny >= M && dir == 0) {  // 동쪽으로 가야하는데 범위를 초과할 떄
            dir = 2;// 서쪽으로 변환
        }
    }

    public static void move() {
        cur_x = cur_x + dx[dir];
        cur_y = cur_y + dy[dir];
        // 1. 주사위 굴리기
        dice_change();
        // 3. 주사위의 아랫면에 있는 정수 A와 주사위가 있는 칸 (x, y)에 있는 정수 B를 비교해 이동 방향을 결정한다
        dir_change();
    }

    // 나중에 내가 아는 것으로 바꾸기
    public static void dice_change() {
        int[] tmp = new int[6];
        for (int i = 0; i < 6; i++) {
            tmp[i] = dice[i];
        }
        if (dir == 0) { // 동
            dice[0] = tmp[0];
            dice[1] = tmp[5];
            dice[2] = tmp[1];
            dice[3] = tmp[2];
            dice[4] = tmp[4];
            dice[5] = tmp[3];
        } else if (dir == 1) { // 남
            dice[0] = tmp[5];
            dice[1] = tmp[1];
            dice[2] = tmp[0];
            dice[3] = tmp[3];
            dice[4] = tmp[2];
            dice[5] = tmp[4];
        } else if (dir == 2) { //서
            dice[0] = tmp[0];
            dice[1] = tmp[2];
            dice[2] = tmp[3];
            dice[3] = tmp[5];
            dice[4] = tmp[4];
            dice[5] = tmp[1];
        } else if (dir == 3) { // 북
            dice[0] = tmp[2];
            dice[1] = tmp[1];
            dice[2] = tmp[4];
            dice[3] = tmp[3];
            dice[4] = tmp[5];
            dice[5] = tmp[0];
        }
    }


    private static void dir_change() {
        if (dice[5] > map[cur_x][cur_y]) {     // 주사위 아랫면이 주사위칸보다 클 때
            dir += 1;
        } else if (dice[5] < map[cur_x][cur_y]) { // 주사위 아랫면이 주사위칸보다 작을 때
            dir -= 1;
        }
        if (dir >= 4) {
            dir -= 4;

        } else if (dir < 0) {
            dir += 4;
        }
    }

    public static void bfs() {
        visit = new boolean[N][M];
        q.add(new int[]{cur_x, cur_y});
        visit[cur_x][cur_y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 > nx || nx >= N || 0 > ny || ny >= M) continue;
                if (map[x][y] == map[nx][ny] && !visit[nx][ny]) {
                    point++;
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
