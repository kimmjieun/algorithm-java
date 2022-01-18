package 알고리즘기초1.c_다이나믹프로그래밍1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1932번 정수 삼각형
public class boj_7_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int map[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 자리의 값 미리 구하기
        for (int i = 1; i < n; i++) {
            map[i][0] += map[i - 1][0];
            map[i][i] += map[i - 1][i - 1];
        }

        // 현재 선택된 수의 대각선 왼쪽/오른쪽에서 선택
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                map[i][j] += Math.max(map[i - 1][j - 1], map[i - 1][j]);
            }
        }

        Arrays.sort(map[n - 1]);
        System.out.println(map[n - 1][n - 1]);
    }
}
