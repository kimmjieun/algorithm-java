package 그래프탐색;

import java.io.*;
import java.util.*;

class PointXYZ {
    int row;
    int col;
    int height;

    public PointXYZ(int height, int row, int col) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}

public class BOJ7569 {
    // 6방향을 나타내기 위한 배열
    static int rowArr[] = {-1, 0, 1, 0, 0, 0};
    static int colArr[] = {0, 1, 0, -1, 0, 0};
    static int heightArr[] = {0, 0, 0, 0, 1, -1};
    static int M, N, H;
    static int tomato[][][];
    static int result;
    static Queue<PointXYZ> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H + 1][N + 1][M + 1];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) queue.add(new PointXYZ(i, j, k));
                }
            }
        }
        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            PointXYZ point = queue.poll();

            int row = point.row;
            int col = point.col;
            int height = point.height;

            for (int i = 0; i < 6; i++) {
                int newHeight = height + heightArr[i];
                int newRow = row + rowArr[i];
                int newCol = col + colArr[i];
                // 6방향으로 토마토가 익을 수 있는지 여부 확인
                if (checkPoint(newHeight, newRow, newCol)) {
                    // 익은 토마토를 큐에 추가
                    queue.add(new PointXYZ(newHeight, newRow, newCol));
                    // 익은 토마토의 값 = 이전에 익은 토마토의 값 + 1
                    tomato[newHeight][newRow][newCol] = tomato[height][row][col] + 1;
                }
            }
        }

        // 최대 값을 구하기 위한 변수 (결과값)
        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (tomato[i][j][k] == 0) { // 하나라도 익지 않은 토마토
                        return -1;
                    }
                    // 토마토가 익는데 걸리는 시간을 구함
                    result = Math.max(result, tomato[i][j][k]);
                }
            }
        }
        if (result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }

    public static boolean checkPoint(int height, int row, int col) {
        // 주어진 범위 밖인지 검사
        if (height < 1 || height > H || row < 1 || row > N || col < 1 || col > M) return false;
        // 아직 익지 않은 토마토라면 true 반환
        if (tomato[height][row][col] == 0) return true;
            // 이미 익어있거나 빈 자리라면 false 반한
        else return false;
    }
}