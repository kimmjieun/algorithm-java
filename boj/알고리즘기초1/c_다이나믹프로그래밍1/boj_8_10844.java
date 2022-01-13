package 알고리즘기초1.c_다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10844번 쉬운 계단 수
public class boj_8_10844 {
    static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j + 1] % mod;
                else if (j == 9) dp[i][j] = dp[i - 1][j - 1] % mod;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
        }
        System.out.println(result % mod);

    }
}
