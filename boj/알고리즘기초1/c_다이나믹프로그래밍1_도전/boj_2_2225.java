package 알고리즘기초1.c_다이나믹프로그래밍1_도전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2225번 합분해
public class boj_2_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int MOD = 1_000_000_000;
        int[][] dp = new int[n + 1][k + 1];

        // k=1일 때 초기화
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        // n=1일 때 초기화
        for (int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        System.out.println(dp[n][k]);
    }
}
