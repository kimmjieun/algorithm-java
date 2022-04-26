package 삼성SW역량테스트기출문제;


import java.util.*;
import java.io.*;

public class BOJ21608 {
    static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(n, 2);

        ArrayList<Set<Integer>> like = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            like.add(new HashSet<Integer>());

        }

        // 조건값 세
        int idx;
        int[] order = new int[size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            idx = Integer.parseInt(st.nextToken());
            order[i] = idx;
            for (int j = 0; j < 4; j++) {
                like.get(idx).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] sit = new int[n][n];

        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };

        int y, x, score = 0, maxS, ty = -1, tx = -1;
        // 학생 순서대로 한명씩 좌석에 배치한다
        for (int index = 0; index < size; index++) {
            maxS = -1; // 처음 비교값을 -1로 하여 나중에 인접한 좋은학생이 0일 때를 대비
            // 0,0부터 n-1,n-1까지 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sit[i][j] != 0) {
                        continue;
                    }
                    score = 0;
                    // 현재 좌석의 상하좌우를 탐색하여 점수를 매긴다
                    for (int k = 0; k < 4; k++) {
                        y = i + dy[k];
                        x = j + dx[k];
                        // 해당하는 좌석에 선호하는 학생이 있으면
                        if (isIn(y, x) && like.get(order[index]).contains(sit[y][x]))
                            score += 5;
                        else if (isIn(y, x) && sit[y][x] == 0)
                            score += 1;
                    }

                    // 해당 좌석의 점수가 높으면 차후에 그 위치에 배치하도록 위치 저장
                    if (score > maxS) {
                        ty = i;
                        tx = j;
                        maxS = score;
                    }
                }

            }
            sit[ty][tx] = order[index];
        }

        int result = 0, cnt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                for (int k = 0; k < 4; k++) {
                    y = i + dy[k];
                    x = j + dx[k];
                    // 각 좌석의 상하좌우에 선호하는 학생이 앉아있으면
                    if (isIn(y, x) && like.get(sit[i][j]).contains(sit[y][x])) {
                        cnt++;
                    }
                }
                // 인접한 학생의 수가 0이면 10^-1이 0.1
                if (cnt != 0)
                    result += (int) Math.pow(10, cnt - 1);
            }
        }
        System.out.println(result);
    }

    public static boolean isIn(int y, int x) {
        if (y < 0 || y >= n || x < 0 || x >= n)
            return false;
        return true;
    }

}
