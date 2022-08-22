package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
    static int[] dice = new int[7];
    static int n, m, x, y;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}; // 동서북남
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        y = Integer.parseInt(in[2]);
        x = Integer.parseInt(in[3]);
        int k = Integer.parseInt(in[4]);

        map = new int[n][m];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());
            move(d);
        }
    }

    static void move(int d) { // d 방향
        int nx = x + dx[d - 1];
        int ny = y + dy[d - 1];
        if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1) return;
        roll(d, nx, ny); // 주사위 굴리기 값바꾸기
        x = nx;
        y = ny; // ?
    }

    // 1 2 3 4 동 서 북 남
    static void roll(int d, int x, int y) {
        int tmp = dice[3]; // 가장 위
        switch (d) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }
        if (map[y][x] == 0) {
            map[y][x] = dice[6]; // 젤 밑바닥

        } else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }
        System.out.println(dice[3]);
    }
}
