package 알고리즘기초1.c_다이나믹프로그래밍1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2133번 타일 채우기
public class boj_12_2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if (n % 2 != 0) {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * dp[2];
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] = dp[i] + (dp[j] * 2);
            }
        }
        System.out.println(dp[n]);
    }
}
