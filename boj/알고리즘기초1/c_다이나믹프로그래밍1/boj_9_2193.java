package boj.알고리즘기초1.c_다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2193번 이친수
public class boj_9_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long D[][] = new long[91][2];

        D[1][0] = 0;
        D[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            D[i][0] = D[i - 1][0] + D[i - 1][1];
            D[i][1] = D[i - 1][0];
        }

        System.out.println(D[n][0] + D[n][1]);
    }
}
