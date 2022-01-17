package 알고리즘기초1.c_다이나믹프로그래밍1_연습;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9465번 스티커
public class boj_5_9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Testcase = Integer.parseInt(br.readLine());
        int[][] arr;
        int[][] dp;
        String[] str;
        for (int t = 0; t < Testcase; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1][2];
            dp = new int[N + 1][2];
            for (int i = 0; i < 2; i++) {
                str = br.readLine().split(" ");
                for (int j = 1; j <= N; j++) {
                    arr[j][i] = Integer.parseInt(str[j - 1]);
                }
            }

            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];
            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + arr[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + arr[i][1];
            }
            System.out.println(Math.max(dp[N][0], dp[N][1]));
        }

    }
}
