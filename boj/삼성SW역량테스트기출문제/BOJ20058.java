package 삼성SW역량테스트기출문제;


import java.io.*;
import java.util.*;

public class BOJ20058 {
    static int N, Q, land, totalIce;
    static int[][] A;
    static int[] L;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            A = divide(L[i]);
            A = melt();
        }
        findBiggest();
        System.out.println(totalIce);
        System.out.println(land);
    }

    static int[][] divide(int L) {
        // 배열 회전 저장 새로 하기
        int[][] tmp = new int[N][N];
        L = (int) Math.pow(2, L);
        for (int i = 0; i < N; i += L) {
            for (int j = 0; j < N; j += L) {
                rotate(i, j, L, tmp);
            }
        }
        return tmp;

    }

    static void rotate(int r, int c, int L, int[][] tmp) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                tmp[r + j][c + L - i - 1] = A[r + i][c + j]; // 어떻게 이 식이 됐을까
            }
        }

    }

    static int[][] melt() {
        // 얼음 녹이기 인접한 얼음칸 3개 미만이면 양 줄이기

        // A 복사본을 만들어 사용해야한다 이유는??
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            tmp[i] = Arrays.copyOf(A[i], N);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 0)
                    continue;
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (A[nx][ny] > 0)
                            cnt++;
                    }
                }
                if (cnt < 3)
                    tmp[i][j]--;
            }
        }
        return tmp;

    }

    static void findBiggest() {

        boolean[][] visit = new boolean[N][N];
        Stack<int[]> stack = new Stack<>();
        land = totalIce = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] > 0 && !visit[i][j]) {
                    visit[i][j] = true;
                    stack.push(new int[]{i, j});
                    totalIce += A[i][j];
                    int cnt = 1;

                    while (!stack.isEmpty()) {
                        int[] tmp = stack.pop();
                        int x = tmp[0];
                        int y = tmp[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (A[nx][ny] > 0 && !visit[nx][ny]) {
                                    visit[nx][ny] = true;
                                    stack.push(new int[]{nx, ny});
                                    cnt++;
                                    totalIce += A[nx][ny];
                                }
                            }
                        }
                    }
                    land = Math.max(land, cnt);

                }
            }
        }
    }
}
