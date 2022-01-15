package boj.알고리즘기초1.c_다이나믹프로그래밍1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1309번 동물원
public class boj_3_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][3];
        Arrays.fill(dp[1], 1); // dp[1][0]=dp[1][1]=dp[1][2]=1

        for (int i = 2; i <= n; i++) {
            // 사자가 i번째 줄에 없어도 되는 경우
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;

            // i번째 1번째 칸에 사자가 있는 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;

            // i번째 줄에 2번째 칸에 사자가 있는 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);

    }
}
