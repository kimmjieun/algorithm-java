package boj.알고리즘기초1.c_다이나믹프로그래밍1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15988번 1, 2, 3 더하기 3
public class boj_1_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());


            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
            }

            System.out.println(dp[n]);
        }
    }
}
