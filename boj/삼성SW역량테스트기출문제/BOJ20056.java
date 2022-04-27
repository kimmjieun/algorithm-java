package 삼성SW역량테스트기출문제;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20056 {
    public static int N;
    public static List<FireBall> list;
    public static Queue<FireBall>[][] grid;

    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new FireBall(r, c, m, d, s));
        }

        grid = new Queue[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new LinkedList<>();

            }
        }

        while (K-- > 0) {
            move();
            combineAndDivide();
        }

        int answer = 0;
        for (FireBall f : list) {
            answer += f.m;
        }
        System.out.print(answer);
    }

    public static void move() {
        for (FireBall f : list) {
            // 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
            f.r = (N + f.r + dx[f.d] * (f.s % N)) % N;
            f.c = (N + f.c + dy[f.d] * (f.s % N)) % N;

            // 이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
            grid[f.r][f.c].add(f);
        }
    }

    public static void combineAndDivide() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j].size() >= 2) {
                    int m_sum = 0, s_sum = 0;
                    int cnt_sum = grid[i][j].size();// 합쳐진 파이어볼의 개수
                    boolean odd = true, even = true;

                    // 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다
                    while (!grid[i][j].isEmpty()) {
                        FireBall f = grid[i][j].poll();
                        m_sum += f.m;// 합쳐진 파이어볼 질량 합
                        s_sum += f.s;// 합쳐진 파이어볼 속력 합

                        // 파이어볼 방향이 모두 홀수이거나 모두 짝수인지
                        if (f.d % 2 == 0) {
                            odd = false;
                        } else {
                            even = false;
                        }
                        list.remove(f);
                    }

                    // 질량 /5
                    int nm = m_sum / 5;

                    // 질량 0인 파이어볼 소멸
                    if (nm == 0)
                        continue;

                    // 속력은 합쳐진 파이어볼 속력합/ 합쳐진 파이어볼 개수
                    int ns = s_sum / cnt_sum;

                    if (odd | even) { // 홀수 Or 짝수
                        for (int k = 0; k < 8; k += 2) { // 방향 0,2,4,6
                            list.add(new FireBall(i, j, nm, k, ns));
                        }
                    } else {
                        for (int k = 1; k < 8; k += 2) { // 1,3,5,7
                            list.add(new FireBall(i, j, nm, k, ns));
                        }
                    }
                } else {
                    grid[i][j].clear();
                }
            }
        }
    }

    public static class FireBall {
        int r, c, m, d, s;

        public FireBall(int r, int c, int m, int d, int s) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }

}

