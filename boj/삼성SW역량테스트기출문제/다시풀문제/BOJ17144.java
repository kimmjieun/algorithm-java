package 삼성SW역량테스트기출문제.다시풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144 {
    static int r, c, t, map[][];
    static int cleaner = -1;
    static Queue<Dust> dusts;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Dust {
        int x, y, w;

        public Dust(int x, int y, int w) {
            super();//?
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map=new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (cleaner == -1 && map[i][j] == -1) {
                    cleaner = i;
                }
            }
        }

        for (int time = 0; time < t; time++) {
            // 미세먼지가 있는 공간 확인
            checkDust();

            // 미세먼지 확산
            spread();

            // 공기청정기 작동
            operate();
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]==-1) continue;
                res += map[i][j];
            }
        }

        System.out.println(res);

    }

    static void checkDust() {
        dusts = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1 || map[i][j] == 0) continue;
                // 미세먼지가 있는 공간과 미세먼지 양
                dusts.add(new Dust(i, j, map[i][j]));
            }
        }
    }

    static void spread() {
        while (!dusts.isEmpty()) {
            Dust now = dusts.poll();
            // 확산될 먼지가 없으면
            if (now.w < 5) continue;
            // 확산되는 양 /5
            int amountOfSpread = now.w / 5;
            int cnt = 0;
            // 인접한 방향으로 확산
            for (int d = 0; d < 4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];
                // 범위를 벗어나면
                if (xx < 0 || xx >= r || yy < 0 || yy >= c) continue;
                // 공기청정기 있으면
                if (map[xx][yy] == -1) continue;

                map[xx][yy] += amountOfSpread;
                ++cnt;
            }

            // 남은 미세먼지 양 계산
            map[now.x][now.y] -= amountOfSpread * cnt;

        }
    }

    //바람이 불면 미세먼지가 방향대로 모두 한칸씩 이동
    private static void operate() {
        // 이게 어려웠다
        int top = cleaner;
        int down = cleaner + 1;

        // 위쪽 공기 청정기 반시계 방향 순환
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--)
            map[i][0] = map[i - 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < c - 1; i++)
            map[0][i] = map[0][i + 1];
        // 위로 당기기
        for (int i = 0; i < top; i++)
            map[i][c - 1] = map[i + 1][c - 1];
        // 오른쪽으로 당기기
        for (int i = c - 1; i > 1; i--)
            map[top][i] = map[top][i - 1];
        // 공기 청정기에서 부는 바람은 미세먼지 없는 바람
        map[top][1]=0;

        // 아래쪽 공기청정기 바람은 시계방향 순환
        // 위로 당기기
        for (int i = down + 1; i < r - 1; i++)
            map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < c - 1; i++)
            map[r - 1][i] = map[r - 1][i + 1];
        // 아래로 당기기
        for (int i = r - 1; i > down; i--)
            map[i][c - 1] = map[i - 1][c - 1];
        // 오른쪽으로 당기기
        for (int i = c - 1; i > 1; i--)
            map[down][i] = map[down][i - 1];

        // 공기청정기에서 부는 바람은 미세먼지 없는 바람
        map[down][1] = 0;
    }
}
