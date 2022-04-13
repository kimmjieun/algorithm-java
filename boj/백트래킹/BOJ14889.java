package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int n;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n];
        back(0, 0);
        System.out.println(min);


    }

    static void back(int idx, int depth) {
        if (depth == n/2) {
            diff();
            return;
        }

        for (int i = idx; i < n; i++) { // 0과 idx 차이 내일 n과 m하면서 정립하기
            if (!visit[i]) {
                visit[i] = true;
                back(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (visit[i] == true && visit[j] == true) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int val = Math.abs(start - link);
        min = Math.min(val, min);
    }


}
