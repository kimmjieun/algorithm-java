package 삼성SW역량테스트기출문제;

import java.util.*;
import java.io.*;

public class BOJ14889 {
    static int n;
    static int[][] map;
    static boolean[] visit;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0, 0);
        System.out.println(min);
    }

    public static void back(int depth, int idx) {
        if (depth == n / 2) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visit[i])
                    list.add(i);
                else
                    list2.add(i);
            }
            int sum = 0;
            int sum2 = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) continue;
                    sum += map[list.get(i)][list.get(j)];
                }
            }
            for (int i = 0; i < list2.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    if (i == j) continue;
                    sum2 += map[list2.get(i)][list2.get(j)];
                }
            }
            min = Math.min(min, Math.abs(sum - sum2));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                back(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
